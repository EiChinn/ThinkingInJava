package com.eichinn.innerclasses;

/**
 * Created by ei_chinn on 2017/2/5.
 */
public class Parcel6 {
    //Nesting a class within a scope
    private void internalTracking(boolean b) {
        if (b) {
            class TrackingSlip {
                private String id;

                public TrackingSlip(String id) {
                    this.id = id;
                }

                String getSlip() {
                    return id;
                }
            }

            TrackingSlip trackingSlip = new TrackingSlip("Nesting a class within a scope");
            String s = trackingSlip.getSlip();
        }
        //Can't use it here! Out of scope:
//        TrackingSlip trackingSlip = new TrackingSlip("Nesting a class within a scope");
    }

    public void track() {
        internalTracking(true);
    }
    public static void main(String[] args) {
        Parcel6 parcel6 = new Parcel6();
        parcel6.track();
    }
}
