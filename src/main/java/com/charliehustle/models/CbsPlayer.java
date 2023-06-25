package com.charliehustle.models;


public class CbsPlayer
{
   private String name;
   private String owner;
   private String team;
   private String position;
   private String salary;
   private String contract;

   public String getName ()
   {
      return name;
   }

   public void setName (String name)
   {
      this.name = name;
   }

   public String getOwner ()
   {
      return owner;
   }

   public void setOwner (String owner)
   {
      this.owner = owner;
   }

   public String getTeam ()
   {
      return team;
   }

   public void setTeam (String team)
   {
      this.team = team;
   }

   public String getPosition ()
   {
      return position;
   }

   public void setPosition (String position)
   {
      this.position = position;
   }

   public String getSalary ()
   {
      return salary;
   }

   public void setSalary (String salary)
   {
      this.salary = salary;
   }

   public String getContract ()
   {
      return contract;
   }

   public void setContract (String contract)
   {
      this.contract = contract;
   }
}
