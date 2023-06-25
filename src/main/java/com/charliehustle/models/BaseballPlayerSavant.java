package com.charliehustle.models;

import com.fasterxml.jackson.annotation.JsonAlias;

public class BaseballPlayerSavant
{
   @JsonAlias("player_id")
   private String playerId;

   @JsonAlias("pa")
   private String plateAppearances;

   @JsonAlias("k_percent")
   private String kPercent;

   @JsonAlias("bb_percent")
   private String bbPercent;

   @JsonAlias("xba")
   private String expectedBa;

   @JsonAlias("xslg")
   private String expectedSlg;

   @JsonAlias("xobp")
   private String expectedObp;

   @JsonAlias("xwoba")
   private String expectedWoba;

   public String getPlayerId ()
   {
      return playerId;
   }

   public void setPlayerId (String playerId)
   {
      this.playerId = playerId;
   }

   public String getPlateAppearances ()
   {
      return plateAppearances;
   }

   public void setPlateAppearances (String plateAppearances)
   {
      this.plateAppearances = plateAppearances;
   }

   public String getkPercent ()
   {
      return kPercent;
   }

   public void setkPercent (String kPercent)
   {
      this.kPercent = kPercent;
   }

   public String getBbPercent ()
   {
      return bbPercent;
   }

   public void setBbPercent (String bbPercent)
   {
      this.bbPercent = bbPercent;
   }

   public String getExpectedBa ()
   {
      return expectedBa;
   }

   public void setExpectedBa (String expectedBa)
   {
      this.expectedBa = expectedBa;
   }

   public String getExpectedSlg ()
   {
      return expectedSlg;
   }

   public void setExpectedSlg (String expectedSlg)
   {
      this.expectedSlg = expectedSlg;
   }

   public String getExpectedObp ()
   {
      return expectedObp;
   }

   public void setExpectedObp (String expectedObp)
   {
      this.expectedObp = expectedObp;
   }

   public String getExpectedWoba ()
   {
      return expectedWoba;
   }

   public void setExpectedWoba (String expectedWoba)
   {
      this.expectedWoba = expectedWoba;
   }

}
