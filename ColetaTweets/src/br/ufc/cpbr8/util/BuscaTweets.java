package br.ufc.cpbr8.util;

import java.text.SimpleDateFormat;
import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import br.ufc.cpbr8.model.Busca;

public class BuscaTweets implements Runnable{

	private Busca busca;
	private Twitter twitter;

	public BuscaTweets(Busca busca, Twitter twitter) {
		this.busca = busca;
		this.twitter = twitter;
	}

	@Override
	public void run() {
		int cont = 1;
		
		long ultimaBusca = 0;
		
		while(cont <= busca.getNumBuscas() ){
			Query query = new Query(busca.getValorBusca());
			//query.setCount(100);
			query.setLang("pt");
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println(dateFormat.format(busca.getDataCriacao()));
			//query.setUntil("2015-02-03");
			
			QueryResult resultadoBusca = null;
			
			try {
				resultadoBusca = twitter.search(query);
				
				CSVUtil csv = new CSVUtil();
				csv.crirarArquivo(busca.getDataCriacao(), cont);
				
				int quantidade = 0;
				
				while(resultadoBusca.hasNext()){
					query = resultadoBusca.nextQuery();
					
					if(cont != 1)
						query.setSinceId(ultimaBusca);
					
					
					resultadoBusca = twitter.search(query);
					
					ultimaBusca = System.currentTimeMillis();
					
					List<Status> listaStatus = resultadoBusca.getTweets();
					
					quantidade+=listaStatus.size();
					
					for (Status status : listaStatus) 
						csv.addlinha(status, busca.getDataCriacao(), cont);
					
					if(quantidade >= busca.getQuantidade())
						break;
					
				}
				
				
				Thread.currentThread().sleep(busca.getTempoBusca());
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
				continue;
			}
			cont++;
		}
		
	}

}
