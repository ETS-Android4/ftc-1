package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class FourWheelDriveController {

    DcMotor lf;
    DcMotor lb;
    DcMotor rf;
    DcMotor rb;

    double forwardPower;
    double rotation;

    double lfPower;
    double lbPower;
    double rfPower;
    double rbPower;

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

    public void step() {
        lf.setPower(lfPower);
        lb.setPower(lbPower);

        rf.setPower(rfPower);
        rb.setPower(rbPower);
    }

}
