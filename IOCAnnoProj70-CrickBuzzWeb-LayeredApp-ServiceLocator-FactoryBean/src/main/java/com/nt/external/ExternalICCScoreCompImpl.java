package com.nt.external;

public class ExternalICCScoreCompImpl implements ExternalIccScoreComp {

	@Override
	public String getScore(int mid) {
	       if(mid==1234)
	    	   return "IND :: 345/6 --> IND Vs PAK";
	       else if(mid==3456)
	    	   return "ENG :: 145/4 --> ENG Vs AUS";
	       else if(mid==3213)
	    	   return "BAN :: 135/4 --> BAN Vs SL";
		    throw new  IllegalArgumentException("invalid match id");
	}

}
