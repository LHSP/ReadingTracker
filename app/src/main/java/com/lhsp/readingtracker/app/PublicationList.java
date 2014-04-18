package com.lhsp.readingtracker.app;

import java.util.ArrayList;

/**
 * Created by LHSP on 15/03/14.
 */
public class PublicationList {
    private static ArrayList<Publication> myPublications = new ArrayList<Publication>();

    //myPublications.add(new Publication("Naruto", "Manga about ninjas that has been running since ever.", 100, 17));
    //myPublications.add(new Publication("Bleach", "Manga about skating that doesn't have skates, but death gods.", 80, 23));


    public static ArrayList<Publication> getMyPublications(){
        // TODO: Read from DB.
        if(myPublications.size() == 0) {
            myPublications.add(new Publication("Naruto", "Manga about ninjas that has been running since ever.", 100, 17, ""));
            myPublications.add(new Publication("Bleach", "Manga about skating that doesn't have skates, but death gods.", 80, 23, ""));
            myPublications.add(new Publication("One Piece", "Do what you want 'cause a pirate is free. You are a pirate!", 80, 23, ""));
            myPublications.add(new Publication("Toriko", "Subete no shokuzai ni kansha wo komete, ITADAKIMASU!", 80, 23, ""));
        }
        return myPublications;
    }

    public static String[] getPublicationsInfos(){
        getMyPublications();
        String[] publicationsInfos = new String[myPublications.size()];
        for (int i = 0; i < publicationsInfos.length; i++){
            publicationsInfos[i] = myPublications.get(i).getInfo();
        }
        return publicationsInfos;
    }

    public static boolean addPublication(Publication publication) {
        myPublications.add(publication);
        // TODO: Save to DB
        return true;
    }
}
