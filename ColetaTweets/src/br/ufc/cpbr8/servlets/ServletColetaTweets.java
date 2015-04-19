package br.ufc.cpbr8.servlets;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.cpbr8.dao.BuscaDAO;
import br.ufc.cpbr8.dao.impl.BuscaJPADAO;
import br.ufc.cpbr8.model.Busca;
import br.ufc.cpbr8.util.AutenticationFactory;
import br.ufc.cpbr8.util.BuscaTweets;
import twitter4j.HashtagEntity;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.UserMentionEntity;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Servlet implementation class ServletColetaTweets
 */
@WebServlet("/ServletColetaTweets")
public class ServletColetaTweets extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final String DIA = "dia";
	private final String HORA = "hora";
	private final String MINUTO = "minuto";
	private final long DIA_MILISEGUNDOS = 86400000;
	private final long HORA_MILISEGUNDOS = 3600000;
	private final long MINUTO_MILISEGUNDOS = 60000;

	public ServletColetaTweets() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String buscaString = request.getParameter("busca");
		String descricaoString = request.getParameter("descricao");
		String tempoPeriodo = request.getParameter("tempo_periodo");
		int tempoValor = Integer.parseInt(request.getParameter("tempo_hora"));
		int quantidade = Integer.parseInt(request.getParameter("quantidade"));
		int repeticoes = Integer.parseInt(request.getParameter("num_buscas"));
		
		
		/*
		 	O tempo para que uma thread procure por novos tweets é calculado em milisegundos
		 	Por exemplo, se a parametro tempoPeriodo for "hora", o valor de uma hora é convertido em milisegundos 
		 	e multiplicado pelo parametro  tempoValor 
		 */

		long tempo = 0;

		if(tempoPeriodo.equals(MINUTO)){
			tempo = MINUTO_MILISEGUNDOS*tempoValor;
		}else if(tempoPeriodo.equals(HORA)){
			tempo = HORA_MILISEGUNDOS*tempoValor;
		}else{
			tempo = DIA_MILISEGUNDOS*tempoValor;
		}

		Busca busca = new Busca(descricaoString, buscaString);
		
		Date dataCriacao = new Date();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		
		String dataString = dateFormat.format(dataCriacao);
		
		busca.setDataCriacao(dataCriacao);
		busca.setTempoBusca(tempo);
		busca.setQuantidade(quantidade);
		busca.setNumBuscas(repeticoes);
		
		//BuscaDAO dao = new BuscaJPADAO();
		//dao.beginTransaction();
		//dao.save(busca);
		//dao.commit();
		//dao.close();
		
		File raiz = new File("/home/alexsandro/coleta/");
		File pasta = new File(raiz, dataString);
	
		if(!pasta.exists())
			pasta.mkdir();
		
		
		//dataString é o nome da pasta onde ficarão os csvs dessa busca
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("/home/alexsandro/coleta/"+dataString+"/info.txt", true));
		bw.write("Descrição :"+busca.getDescricao());
		bw.write("\n");
		
		bw.write("Busca por: "+busca.getValorBusca());
		bw.write("\n");
		
		bw.write("Até: "+dataString);
		bw.write("\n");
		
		bw.write("Quantidade de tweets por busca: "+String.valueOf(busca.getQuantidade()));
		bw.write("\n");
		
		bw.write("Intervalo de busca: "+ tempoValor +" - "+tempoPeriodo+" - "+String.valueOf(busca.getTempoBusca()+"(ms)"));
		bw.write("\n");
		
		bw.write("Repetições: "+busca.getNumBuscas());
		bw.write("\n");
		
		bw.close();
		
		Twitter twitter = AutenticationFactory.getTwitter();
		Thread buscaThread = new Thread(new BuscaTweets(busca, twitter));
		buscaThread.start();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");  
	    dispatcher.forward(request, response); 
		
	}


}
