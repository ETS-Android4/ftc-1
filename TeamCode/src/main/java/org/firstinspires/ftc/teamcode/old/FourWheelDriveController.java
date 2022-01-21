package org.firstinspires.ftc.teamcode.old;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

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
    static final short SIDE_BOTH  = 3;

    public FourWheelDriveController(DcMotor lfm, DcMotor lbm, DcMotor rfm, DcMotor rbm, boolean invert) {
        lf = lfm;
        lb = lbm;
        rf = rfm;
        rb = rbm;

        if (invert) {
            lf.setDirection(DcMotor.Direction.REVERSE);
            lb.setDirection(DcMotor.Direction.REVERSE);
            rf.setDirection(DcMotor.Direction.FORWARD);
            rb.setDirection(DcMotor.Direction.FORWARD);
        } else {
            lf.setDirection(DcMotor.Direction.FORWARD);
            lb.setDirection(DcMotor.Direction.FORWARD);
            rf.setDirection(DcMotor.Direction.REVERSE);
            rb.setDirection(DcMotor.Direction.REVERSE);
        }


    }

    /* Set control values */
    public void setPower(double pwr) {
        forwardPower = pwr;
    }

    public void setRotation(double rot) {
        rotation = rot;
    }

    protected void setSidePower(short side, double pwr) {
        if (side == SIDE_LEFT || side == SIDE_BOTH) {
            lfPower = pwr;
            lbPower = pwr;
        }
        if (side == SIDE_RIGHT || side == SIDE_BOTH) {
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
