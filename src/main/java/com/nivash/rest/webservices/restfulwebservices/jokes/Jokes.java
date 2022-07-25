package com.nivash.rest.webservices.restfulwebservices.jokes;

public class Jokes {

    private Integer id;
    private String setup;
    private String punchline;

    public Jokes(Integer id, String setup, String punchline) {
        this.id = id;
        this.setup = setup;
        this.punchline = punchline;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSetup() {
        return setup;
    }

    public void setSetup(String setup) {
        this.setup = setup;
    }

    public String getPunchline() {
        return punchline;
    }

    public void setPunchline(String punchline) {
        this.punchline = punchline;
    }

    @Override
    public String toString() {
        return "Jokes{" +
                "id=" + id +
                ", setup='" + setup + '\'' +
                ", punchline='" + punchline + '\'' +
                '}';
    }
}
