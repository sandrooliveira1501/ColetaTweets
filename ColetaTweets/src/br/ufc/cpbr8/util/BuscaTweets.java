package br.ufc.cpbr8.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import twitter4j.HashtagEntity;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.User;
import twitter4j.UserMentionEntity;
import br.ufc.cpbr8.dao.TweetDAO;
import br.ufc.cpbr8.dao.UsuarioDAO;
import br.ufc.cpbr8.dao.impl.TweetJPADAO;
import br.ufc.cpbr8.dao.impl.UsuarioJPADAO;
import br.ufc.cpbr8.model.Busca;
import br.ufc.cpbr8.model.Tweet;
import br.ufc.cpbr8.model.Usuario;

public class BuscaTweets implements Runnable {

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

		while (cont <= busca.getNumBuscas()) {
			Query query = new Query();
			query.setQuery(busca.getValorBusca());
			query.setLang("pt");

			//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			//System.out.println(dateFormat.format(busca.getDataCriacao()));
			//query.setUntil("2015-02-03");

			QueryResult resultadoBusca = null;

			try {
				resultadoBusca = twitter.search(query);

				CSVUtil csv = new CSVUtil();
				csv.crirarArquivo(busca.getDataCriacao(), cont);

				int quantidade = 0;

				while (resultadoBusca.hasNext()) {
					query = resultadoBusca.nextQuery();

					if (cont != 1)
						query.setSinceId(ultimaBusca);

					resultadoBusca = twitter.search(query);

					List<Status> listaStatus = resultadoBusca.getTweets();

					quantidade += listaStatus.size();

					Set<Usuario> usuarios = new LinkedHashSet<>();
					List<Tweet> tweets = new ArrayList<Tweet>();

					for (Status status : listaStatus) {
						csv.addlinha(status, busca.getDataCriacao(), cont);
						User user = status.getUser();

						Usuario usuario = new Usuario();
						usuario.setId(user.getId());
						usuario.setLocalizacao(user.getLocation());
						usuario.setNome(user.getName());
						usuario.setUserName(user.getScreenName());
						usuarios.add(usuario);

						Tweet tweet = new Tweet();
						tweet.setUsuario(usuario);
						tweet.setBusca(busca);
						tweet.setTexto(status.getText());
						tweet.setId(status.getId());
						tweet.setData(status.getCreatedAt());
						try {
							tweet.setLatitude(status.getGeoLocation()
									.getLatitude());
						} catch (Exception e) {
						}
						try {
							tweet.setLongitude(status.getGeoLocation()
									.getLongitude());
						} catch (Exception e) {
						}
						HashtagEntity hashtags[] = status.getHashtagEntities();
						List<String> hashtagsList = new ArrayList<String>();
						for (int i = 0; i < hashtags.length; i++) {
							hashtagsList.add(hashtags[i].getText());
						}
						tweet.setHashTags(hashtagsList);
						UserMentionEntity mencionados[] = status
								.getUserMentionEntities();
						List<String> mencionadosList = new ArrayList<String>();
						for (int i = 0; i < mencionados.length; i++) {
							mencionadosList.add(mencionados[i].getText());
						}
						tweet.setMencionados(mencionadosList);
						tweets.add(tweet);

					}

					/*
					 * UsuarioDAO usuarioDao = new UsuarioJPADAO();
					 * usuarioDao.beginTransaction(); for (Usuario u : usuarios)
					 * { if(usuarioDao.find(u.getId()) == null)
					 * usuarioDao.save(u); } usuarioDao.commit();
					 * usuarioDao.close();
					 * 
					 * TweetDAO tweetDao = new TweetJPADAO();
					 * tweetDao.beginTransaction(); for(Tweet t: tweets){
					 * if(tweetDao.find(t.getId()) == null) tweetDao.save(t); }
					 * tweetDao.commit(); tweetDao.close();
					 */

					if (quantidade >= busca.getQuantidade())
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
