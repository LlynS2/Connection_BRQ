package com.smarttech.ConnectionBRQ.Model.Entities.Enumeration;

public enum Gender {
	
	 Male("Male"),
	 Female("Female"),
	 Other("Other");

	    private String description;

	    Gender(String description) {
	        this.description = description;
	    }

	    public String getDescription() {
	        return description;
	    }
}

/* 𝐏𝐑𝐎𝐉𝐄𝐂𝐓'𝐒 𝐑𝐄𝐏𝐎𝐒𝐈𝐓𝐎𝐑𝐘 : https://github.com/LlynS2/Connection_BRQ */
