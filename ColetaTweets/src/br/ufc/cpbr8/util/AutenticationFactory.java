package br.ufc.cpbr8.util;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class AutenticationFactory {

	private static final String CONSUMERKEY = "R3hXH79npWMm0l0EvG42lnzm5";
	private static final String CONSUMERSECRET = "DVMGOYoq9OlHVYwYWB1LQrAXVYCHSm9swnBQ6a5kHDOaBOXHf1";
	private static final String ACCESSTOKEN = "211586230-MjyNtjuEuDBmO9znz1Z4f8sHRCnz8JHMJYS4YeHj";
	private static final String ACCESSTOKENSECRET = "rdC1y2d0iBijiki7U3aKelCkrmBC6zJS0yTaWahx1Juvr";

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
