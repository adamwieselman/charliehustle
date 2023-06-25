package com.charliehustle.enums;

import java.util.HashMap;
import java.util.Map;

public enum PlayType {
    PUNT_BLOCKED(2),
    FIRST_DOWN_RUSH(3),    // don't care about
    FIRST_DOWN_PASS(4),     // don't care about
    FIRST_DOWN_PENALTY(5),     // don't care about
    THIRD_DOWN_CONVERTED(6),    // don't care about
    THIRD_DOWN_FAILED(7),   // don't care about
    FOURTH_DOWN_CONVERTED(8),     // don't care about
    FOURTH_DOWN_FAILED(9),       // don't care about
    RUSH_YARDS(10),
    RUSH_YARDS_TD(11),
    LATERAL_RUSHING_YARDS(12),  // don't care about
    LATERAL_RUSHING_YARDS_TD(13),
    INCOMPLETE_PASS(14),
    PASSING_YARDS(15),
    PASSING_YARDS_TD(16),
    INTERCEPTION(19),
    SACK_YARDS(20),
    RECEIVING_YARDS(21),  // don't care about
    RECEIVING_YARDS_TD(22), // don't care about
    LATERAL_RECEIVING_YARDS(23), // don't care about
////    LATERAL_RECEIVING_YARDS_TD(24),
    INTERCEPTION_RETURN_YARDS(25),
    INTERCEPTION_RETURN_YARDS_TD(26),
    LATERAL_INTERCEPTION_RETURN_YARDS(27),  // don't care about
////    LATERAL_INTERCEPTION_RETURN_YARDS_TD(28),
    PUNTING_YARDS(29),
    PUNTING_INSIDE_TWENTY(30),  // don't care about
    PUNT_IN_ENDZONE(31),  // don't care about
    PUNT_TOUCHBACK_KICKING(32),
    PUNT_RETURN_YARDS(33),
    PUNT_RETURN_YARDS_TD(34),
    LATERAL_PUNT_RETURN_YARDS(35),  // don't care about
////    LATERAL_PUNT_RETURN_YARDS_TD(36),
    PUNT_OUT_OF_BOUNDS(37),
    PUNT_DOWNED(38),
    PUNT_FAIR_CATCH(39),
    PUNT_TOUCHBACK_RECEIVING(40),
    KICKOFF_YARDS(41),
    KICKOFF_INSIDE_TWENTY(42), // don't care about
    KICKOFF_IN_ENDZONE(43),
    KICKOFF_TOUCHBACK_KICKING(44), // don't care about
    KICKOFF_RETURN_YARDS(45),
    KICKOFF_RETURN_YARDS_TD(46),
    LATERAL_KICKOFF_RETURN_YARDS(47),   // don't care about
////    LATERAL_KICKOFF_RETURN_YARDS_TD(48),
    KICKOFF_OUT_OF_BOUNDS(49),
    KICKOFF_FAIR_CATCH(50),
    KICKOFF_TOUCHBACK_RECEIVING(51),
    FUMBLE_FORCED(52),
    FUMBLE_NOT_FORCED(53),
    FUMBLE_OUT_OF_BOUNDS(54),
    OWN_FUMBLE_RECOVERY_YARDS(55),
    OWN_FUMBLE_RECOVERY_YARDS_TD(56),
    LATERAL_OWN_FUMBLE_RECOVERY_YARDS(57), // don't care about
////    LATERAL_OWN_FUMBLE_RECOVERY_YARDS_TD(58),
    OPP_FUMBLE_RECOVERY_YARDS(59),
    OPP_FUMBLE_RECOVERY_YARDS_TD(60),
   LATERAL_OPP_FUMBLE_RECOVERY_YARDS(61),
////    LATERAL_OPP_FUMBLE_RECOVERY_YARDS_TD(62),
    MISCELLANEOUS_YARDS(63),  // don't care about
    MISCELLANEOUS_YARDS_TD(64),
    TIMEOUT(68),  // don't care about
    FIELD_GOAL_YARDS_MISSED(69),
    FIELD_GOAL_YARDS_MADE(70),
    FIELD_GOAL_YARDS_BLOCKED(71),
    EXTRA_POINT_GOOD(72),
    EXTRA_POINT_FAILED(73),
    EXTRA_POINT_BLOCKED(74),
    TWO_POINT_RUSH_GOOD(75),
    TWO_POINT_RUSH_FAILED(76),
    TWO_POINT_PASS_GOOD(77),
    TWO_POINT_PASS_FAILED(78),
    SOLO_TACKLE(79),
    ASSISTED_TACKLE(80),
    TACKLE_ASSIST(82),
    SOLO_SACK_YARDS(83),   // don't care about
    ASSIST_SACK_YARDS(84),
    PASS_DEFENSE_PLAYER(85),
    PUNT_BLOCKED_PLAYER(86),
    EXTRA_POINT_BLOCKED_PLAYER(87),
    FIELD_GOAL_BLOCKED_PLAYER(88),
    SAFETY_TACKLE(89),
    FORCED_FUMBLE_PLAYER(91),
    PENALTY_YARDS(93),
    TACKLED_FOR_LOSS(95),    // don't care about
////    EXTRA_POINT_SAFETY(96),
////    TWO_POINT_RUSH_SAFETY(99),
////    TWO_POINT_PASS_SAFETY(100),
    KICKOFF_DOWNED(102), // don't care about
////    LATERAL_SACK_YARDS(103),
    TWO_POINT_PASS_RECEPTION_GOOD(104),
    TWO_POINT_PASS_RECEPTION_FAILED(105),
    FUMBLE_LOST(106),
    OWN_KICKOFF_RECOVERY(107), // don't care about
////    OWN_KICKOFF_RECOVERY_TD(108),
    QB_HIT(110),
    AIR_YARDS_COMPLETE(111),
    AIR_YARDS_INCOMPLETE(112),
    YARDS_AFTER_CATCH(113),
    TARGETED_RECEIVER(115),
    TACKLE_FOR_LOSS_PLAYER(120), // don't care about
////    EXTRA_POINT_ABORTED(301),
    TACKLE_FOR_LOSS_YARDS(402),  //don't care about
    KICKOFF_YARD_LENGTH(410),
////    TWO_POINT_RETURN(420),
////    DEFENSIVE_EXTRA_POINT_CONV(406),
////    DEFENSIVE_TWO_POINT_CONV(404),
////    DEFENSIVE_EXTRA_POINT_ATTEMPT(405),
    DEFENSIVE_TWO_POINT_ATTEMPT(403); //don't care about

    // declaring private variable for getting values
    private Integer playTypeNumber;

    // getter method
    public Integer getPlayTypeNumber()
    {
        return this.playTypeNumber;
    }

    // enum constructor - cannot be public or protected
    private PlayType(Integer playTypeNumber)
    {
        this.playTypeNumber = playTypeNumber;
    }

    // Reverse-lookup map for getting a day from an abbreviation
    private static final Map<Integer, PlayType> playTypeLookup = new HashMap<Integer, PlayType>();

    public static PlayType get(Integer playTypeNumber) {
        return playTypeLookup.get(playTypeNumber);
    }

    static {
        for (PlayType d : PlayType.values()) {
            playTypeLookup.put(d.getPlayTypeNumber(), d);
        }
    }
}
