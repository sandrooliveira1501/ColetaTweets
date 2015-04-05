package br.ufc.cpbr8.util;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class AutenticationFactory {

	private static final String CONSUMERKEY = "e6bDAG2da94gdEdvhJzmOWhiM";
	private static final String CONSUMERSECRET = "8Qa64vNJ7OJUAh1zYIGp8rZSloGkt4SZDSuBOrUwOjgOoi92zO";
	private static final String ACCESSTOKEN = "275657169-NVxtKJIIQCeIU1g3DczpZ3gbUvahJ748r6Jnqto7";
	private static final String ACCESSTOKENSECRET = "grfzEeIZ5vBp4cNohyRjawnn1Gd6eqNplhLVpVV5tVXGA";

	public static Twitter getTwitter(){
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		.setOAuthConsumerKey(CONSUMERKEY)
		.setOAuthConsumerSecret(CONSUMERSECRET)
		.setOAuthAccessToken(ACCESSTOKEN)
		.setOAuthAccessTokenSecret(ACCESSTOKENSECRET);
		
		TwitterFactory twitterFactory = new TwitterFactory(cb.build());
		
		Twitter twitter = twitterFactory.getInstance();
		return twitter;
	}

}
