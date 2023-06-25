package com.charliehustle.models;

import java.util.ArrayList;
import java.util.List;

public class BaseballSavantData
{
   public BaseballSavantData(){
      baseballPlayerSavantList = new ArrayList<>();
   }

   private List<BaseballPlayerSavant> baseballPlayerSavantList;

   public List<BaseballPlayerSavant> getBaseballPlayerSavantList ()
   {
      return baseballPlayerSavantList;
   }

   public void setBaseballPlayerSavantList (List<BaseballPlayerSavant> baseballPlayerSavantList)
   {
      this.baseballPlayerSavantList = baseballPlayerSavantList;
   }
}
