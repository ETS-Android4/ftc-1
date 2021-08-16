package org.firstinspires.ftc.teamcode.Annabelle;

import com.qualcomm.robotcore.hardware.DcMotor;


public class AnnabelleDriveController {

    DcMotor lf;
    DcMotor lb;
    DcMotor rf;
    DcMotor rb;

    double lfPower;
    double lbPower;
    double rfPower;
    double rbPower;


    public static final short NONE        = 0b0000;
    public static final short LEFTFRONT   = 0b0001;
    public static final short LEFTBACK    = 0b0010;
    public static final short RIGHTFRONT  = 0b0100;
    public static final short RIGHTBACK   = 0b1000;
    public static final short LEFT        = 0b0011;
    public static final short RIGHT       = 0b1100;
    public static final short ALL         = 0b1111;

    double power;

    public AnnabelleDriveController(DcMotor lfm, DcMotor lbm, DcMotor rfm, DcMotor rbm) {
        lf = lfm;
        lb = lbm;
        rf = rfm;
        rb = rbm;

        lf.setDirection(DcMotor.Direction.FORWARD);
        lb.setDirection(DcMotor.Direction.FORWARD);
        rf.setDirection(DcMotor.Direction.REVERSE);
        rb.setDirection(DcMotor.Direction.REVERSE);
    }

    public void setPower(double pwr) {
        setPower(pwr, NONE);
    }

    public void setPower(double pwr, short motor) {
        if ((motor | LEFTFRONT) != 0)   lfPower = pwr;
        if ((motor | LEFTBACK) != 0)    lbPower = pwr;
        if ((motor | RIGHTFRONT) != 0)  rfPower = pwr;
        if ((motor | RIGHTBACK) != 0)   rbPower = pwr;
    }

    public void step() {
        lf.setPower(lfPower);
        lb.setPower(lbPower);
        rf.setPower(rfPower);
        rb.setPower(rbPower);
    }

}
