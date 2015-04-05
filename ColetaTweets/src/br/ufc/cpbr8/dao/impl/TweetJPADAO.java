package br.ufc.cpbr8.dao.impl;

import br.ufc.cpbr8.dao.TweetDAO;
import br.ufc.cpbr8.model.Tweet;
import br.ufc.cpbr8.model.Usuario;

public class TweetJPADAO extends GenericJPADAO<Tweet> implements TweetDAO{

	public TweetJPADAO() {
		super();
		this.persistentClass = Tweet.class;
	}

	@Override
	public boolean verificaTweet(Tweet tweet) {
		try{
			Tweet tweetVerificado = em.find(Tweet.class, tweet.getId());
			if(tweetVerificado != null)
				return true;
		}catch(Exception e){
			return false;
		}
		
		return false;
	}
	
}
