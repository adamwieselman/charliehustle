package com.charliehustle.beans;

public class GameContext {

   private String homeTeam;
   private String awayTeam;
   private boolean homeHasBall;
   private boolean tempHomeHasBall;
   private Integer homeScore;
   private Integer awayScore;
   private Integer tempHomeScore;
   private Integer tempAwayScore;

   public GameContext(){
       homeScore = 0;
       awayScore = 0;
       tempHomeScore = 0;
       tempAwayScore = 0;
   }


    public Integer getTempHomeScore() {
        return tempHomeScore;
    }

    public void setTempHomeScore(Integer tempHomeScore) {
        this.tempHomeScore = tempHomeScore;
    }

    public Integer getTempAwayScore() {
        return tempAwayScore;
    }

    public void setTempAwayScore(Integer tempAwayScore) {
        this.tempAwayScore = tempAwayScore;
    }

    public Integer getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(Integer homeScore) {
        this.homeScore = homeScore;
    }

    public Integer getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(Integer awayScore) {
        this.awayScore = awayScore;
    }

    public boolean isTempHomeHasBall() {
        return tempHomeHasBall;
    }

    public void setTempHomeHasBall(boolean tempHomeHasBall) {
        this.tempHomeHasBall = tempHomeHasBall;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        if(homeTeam.equals("ARI")){
            this.homeTeam = "ARZ";
        }else if(homeTeam.equals("HOU")){
            this.homeTeam = "HST";
        }else if(homeTeam.equals("LAR")) {
            this.homeTeam = "LA";
        }else if(homeTeam.equals("BAL")) {
            this.homeTeam = "BLT";
        }else if(homeTeam.equals("CLE")) {
            this.homeTeam = "CLV";
        }else if(homeTeam.equals("JAC")) {
            this.homeTeam = "JAX";
        }else {
            this.homeTeam = homeTeam;
        }
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
       if(awayTeam.equals("ARI")){
           this.awayTeam = "ARZ";
       }else if(awayTeam.equals("HOU")){
           this.awayTeam = "HST";
       }else if(awayTeam.equals("LAR")) {
           this.awayTeam = "LA";
       }else if(awayTeam.equals("BAL")) {
           this.awayTeam = "BLT";
       }else if(awayTeam.equals("CLE")) {
           this.awayTeam = "CLV";
       }else if(awayTeam.equals("JAC")) {
           this.awayTeam = "JAX";
       }else {
           this.awayTeam = awayTeam;
       }
   }

    public boolean isHomeHasBall() {
        return homeHasBall;
    }

    public void setHomeHasBall(boolean homeHasBall) {
        this.homeHasBall = homeHasBall;
    }
}
