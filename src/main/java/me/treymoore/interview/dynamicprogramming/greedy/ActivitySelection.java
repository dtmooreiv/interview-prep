package me.treymoore.interview.dynamicprogramming.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    public static class Activity{
        public String name;
        public int start;
        public int end;

        public Activity(String name, int start, int end) {
            this.name = name;
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString(){
            return this.name;
        }
    }

    //Returns an array containing activities that is the largest number on activities
    //That can be accommodated (no activities overlap)
    //Assumes that activities is sorted by increasing finishing time
    public static Activity[] activitySelection(Activity[] activities) {
        ArrayList<Activity> plan = new ArrayList<Activity>();
        //Add the activity with the earliest finishing time
        plan.add(activities[0]);
        int i = 1;
        for(int m = 2; m < activities.length; m++) {
            if(activities[m].start >= activities[i].end) {
                plan.add(activities[m]);
                i = m;
            }
        }
        return plan.toArray(new Activity[plan.size()]);
    }

    public static void sortActivities(Activity[] activities) {
        Arrays.sort(activities, new ActivityComparator());
    }

    static class ActivityComparator implements Comparator<Activity> {
        public int compare(Activity a1, Activity a2) {
            return a1.end > a2.end ? 1 : -1;
        }
    }

    public static void main(String[] args) {
        Activity act1 = new Activity("Boxing", 1, 4);
        Activity act2 = new Activity("Running", 3, 5);
        Activity act3 = new Activity("Kick-Boxing", 0, 6);
        Activity act4 = new Activity("Group Cycling", 5, 7);
        Activity act5 = new Activity("Zumba", 3, 8);
        Activity act6 = new Activity("Yoga", 5, 9);
        Activity act7 = new Activity("Power Yoga", 6, 10);
        Activity act8 = new Activity("Meditation", 8, 11);
        Activity act9 = new Activity("Jump Rope", 8, 12);
        Activity act10 = new Activity("Dance", 12, 14);
        Activity[] activities = {act1,act2,act3,act4,act5,act6,act7,act8,act9,act10};

        sortActivities(activities);
        Activity[] plan = activitySelection(activities);
        System.out.println(Arrays.toString(plan));
    }
}

