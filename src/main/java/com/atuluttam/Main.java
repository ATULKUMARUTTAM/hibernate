package com.atuluttam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Starting the Hibernate Application");

        // Create a Song object
        Song song1 = new Song();
        song1.setSongName("Broken Angel");
        song1.setArtist("Akon");

        // Save the Song using DAO
        SongDAO songDAO = new SongDAO();
        songDAO.saveSong(song1);

        logger.info("Song saved successfully");
    }
}
