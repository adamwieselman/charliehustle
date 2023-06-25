package com.charliehustle.beans;

import java.util.Objects;

public class StatKey{

   private final String hand;
   private final String stat;
   private final String statBreakdown;
   private final String batterPitcher;
   private final int daysGone;
   private final boolean hitQuality;

   public StatKey (String hand,
                   String stat,
                   String statBreakdown,
                   String batterPitcher,
                   int daysGone,
                   boolean hitQuality) {
      this.hand = hand;
      this.batterPitcher = batterPitcher;
      this.stat = stat;
      this.statBreakdown = statBreakdown;
      this.daysGone = daysGone;
      this.hitQuality = hitQuality;
   }

   @Override
   public boolean equals (Object o)
   {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      StatKey statKey = (StatKey) o;
      return hand == statKey.hand && daysGone == statKey.daysGone && Objects.equals(batterPitcher, statKey.batterPitcher) && Objects.equals(stat, statKey.stat)&& Objects.equals(statBreakdown, statKey.statBreakdown) && hitQuality==statKey.hitQuality;
   }

   @Override
   public int hashCode ()
   {
      return Objects.hash(hand, batterPitcher, statBreakdown, stat, daysGone, hitQuality);
   }
}
