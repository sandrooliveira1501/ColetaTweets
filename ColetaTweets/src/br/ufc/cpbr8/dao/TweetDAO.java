package br.ufc.cpbr8.dao;

import br.ufc.cpbr8.model.Tweet;

public interface TweetDAO extends GenericDAO<Tweet>{

	public boolean verificaTweet(Tweet tweet);
	
}
