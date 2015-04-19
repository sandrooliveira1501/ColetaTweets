package br.ufc.cpbr8.util;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import twitter4j.HashtagEntity;
import twitter4j.Status;
import twitter4j.UserMentionEntity;

public class CSVUtil {

	BufferedWriter bw;

	public void crirarArquivo(Date data, int contBusca){

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String dataString = format.format(data);
		
		String nomeArquivo = "/home/alexsandro/coleta/"+dataString+"/"+contBusca+".csv";
		Path pathArquivo = Paths.get(nomeArquivo);
		try{
			
			if(!Files.exists(pathArquivo)){
				System.out.println(pathArquivo);
				System.out.println(nomeArquivo);
				Files.createFile(pathArquivo);
			}
			
			bw = new BufferedWriter(new FileWriter(nomeArquivo, true));
			
			bw.write("id;status;data;usuarioId;nome;username;localizacao;mencionados;hashtags\n"); 
			bw.close();
		}catch (FileNotFoundException ex){
			ex.printStackTrace(); 
		}catch (IOException e){
			e.printStackTrace(); 
		}

	}

	public void addlinha(Status status, Date data, int cout){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String dataString = format.format(data);
		String linha = toString(status);
		try {

			Path path = Paths.get("/home/alexsandro/coleta/"+dataString+"/"+cout+".csv");
			
			bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
			
			System.out.println(linha);
			bw.write(linha);
			bw.append("\n");
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String toString(Status tweet){
		String id =  "\"" +String.valueOf(tweet.getId())+"\"";
		String status = tweet.getText();
		status = status.replaceAll("[\"\\n]","");
		//status.replaceAll("\n","");
		status = "\""+status+"\"";
		DateFormat formato = new SimpleDateFormat("dd/MM/yy hh:mm");
		String data = "\""+formato.format(tweet.getCreatedAt())+"\"";
		String usuarioId = "\""+String.valueOf(tweet.getUser().getId())+"\"";
		String nome = "\""+tweet.getUser().getName()+"\"";
		String userName = "\""+tweet.getUser().getScreenName()+"\"";
		String localizacao = "\""+tweet.getUser().getLocation()+"\""; 
		String mencionados = "";
		String hashTags = "";
		
		UserMentionEntity[] ume = tweet.getUserMentionEntities();
		if(ume.length > 0){
			for(int i = 0; i<ume.length; i++){
				String mencionado = ume[i].getScreenName();
				mencionados+=mencionado+" ";
			}
		}
		
		mencionados = "\""+mencionados+"\"";
		
		HashtagEntity[] hte = tweet.getHashtagEntities();

		if(hte.length > 0){
			for (int i = 0; i < hte.length; i++) {
				String tag = hte[i].getText();
				hashTags+=tag+" ";
			}
		}

		hashTags = "\""+hashTags+"\"";
		
		StringBuffer string = new StringBuffer();
		string.append(id+";");
		string.append(status+";");
		string.append(data+";");
		string.append(usuarioId+";");
		string.append(nome+";");
		string.append(userName+";");
		string.append(localizacao+";");
		string.append(mencionados+";");
		string.append(hashTags+";");
		return string.toString();

	}

}
