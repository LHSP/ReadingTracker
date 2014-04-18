package com.lhsp.readingtracker.app;

/**
 * Created by LHSP on 15/03/14.
 */
public class Publication {
    String title;
    String description;
    int totalEditions;
    int currentEditions;
    String coverImage;

    Edition[] editions;

    public Publication(String title, String description, int totalEditions, int currentEditions, String coverImage) {
        this.title = title;
        this.description = description;
        this.totalEditions = totalEditions;
        this.currentEditions = currentEditions;
        this.coverImage = coverImage;

        editions = new Edition[]{
                new Edition("Primeira edição", true),
                new Edition("Segunda edição", false),
                new Edition("Terceira edição", true),
                new Edition("Edição Especial", false)
        };
    }

    public String getInfo(){
        return new StringBuilder(this.title).append(" (").append(this.currentEditions).append("/").append(this.totalEditions).append(")").toString();
    }

    public Edition[] getEditions(){
        return editions;
    }
}
