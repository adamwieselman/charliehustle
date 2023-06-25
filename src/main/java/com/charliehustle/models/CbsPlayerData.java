package com.charliehustle.models;

import java.util.ArrayList;
import java.util.List;

public class CbsPlayerData
{
   private List<CbsPlayer> cbsPlayerList;

   public CbsPlayerData(){
      cbsPlayerList = new ArrayList<>();
   }

   public List<CbsPlayer> getCbsPlayerList ()
   {
      return cbsPlayerList;
   }

   public void setCbsPlayerList (List<CbsPlayer> cbsPlayerList)
   {
      this.cbsPlayerList = cbsPlayerList;
   }
}
