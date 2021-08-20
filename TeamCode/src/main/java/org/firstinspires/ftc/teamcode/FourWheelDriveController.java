package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class FourWheelDriveController {

    DcMotor lf;
    DcMotor lb;
    DcMotor rf;
    DcMotor rb;

    protected double forwardPower;
    protected double rotation;

    protected double lfPower;
    protected double lbPower;
    protected double rfPower;
    protected double rbPower;

    static final short SIDE_RIGHT = 1;
    static final short SIDE_LEFT  = 2;

    public FourWheelDriveController(DcMotor lfm, DcMotor lbm, DcMotor rfm, DcMotor rbm) {
        lf = lfm;
        lb = lbm;
        rf = rfm;
        rb = rbm;
    }

    /* Set control values */
    public void setPower(double pwr) {
        forwardPower = pwr;
    }

    public void setRotation(double rot) {
        rotation = rot;
    }

    protected void setSidePower(short side, double pwr) {
        if (side == SIDE_LEFT) {
            lfPower = pwr;
            lbPower = pwr;
        } else if (side == SIDE_RIGHT) {
            rfPower = pwr;
            rbPower = pwr;
        }
    }

    protected void step() {
        lf.setPower(lfPower);
        lb.setPower(lbPower);

        rf.setPower(rfPower);
        rb.setPower(rbPower);
    }

}
