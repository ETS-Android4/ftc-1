package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class AnnabelleDriveController {

    DcMotor lf;
    DcMotor lb;
    DcMotor rf;
    DcMotor rb;

    double forwardPower;
    double rotation;
    double strafe;

    double lfPower;
    double lbPower;
    double rfPower;
    double rbPower;

    short SIDE_RIGHT = 1;
    short SIDE_LEFT  = 2;

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

    /* Set control values */
    public void setPower(double pwr) {
        forwardPower = pwr;
    }

    public void setRotation(double rot) {
        rotation = rot;
    }

    public void setStrafe(double str) {
        strafe = str;
    }

    private void setSidePower(short side, double pwr) {
        if (side == SIDE_LEFT) {
            lfPower = pwr;
            lbPower = pwr;
        } else if (side == SIDE_RIGHT) {
            rfPower = pwr;
            rbPower = pwr;
        }
    }

    public void step(Telemetry telemetry) {

        if ((strafe > 0.5 || strafe < -0.5) && rotation != 0) rotation = 0;

        setSidePower(SIDE_RIGHT, rotation + forwardPower);
        setSidePower(SIDE_LEFT, -rotation + forwardPower);

        if (strafe > 0.5 || strafe < -0.5) {
            if (rotation != 0) rotation = 0;
            if ((forwardPower > -0.5 && forwardPower < 0.5)) {
                /* Left and Right */
                rbPower = strafe;
                rfPower = -strafe;
                lfPower = strafe;
                lbPower = -strafe;
            } else if (forwardPower < -0.5) {
                /* Diagonal up right and down left */
                lfPower = Math.floor(strafe * 2);
                lbPower = 0;
                rfPower = 0;
                rbPower = Math.floor(strafe * 2);
            } else if (forwardPower > 0.5) {
                /* Diagonal up left and down right */
                lfPower = 0;
                lbPower = Math.floor(strafe * 2);
                rfPower = Math.floor(strafe * 2);
                rbPower = 0;
            }
        }

        telemetry.addData("Left Front Power", lfPower);
        telemetry.addData("Left Back Power", lbPower);
        telemetry.addData("Right Front Power", rfPower);
        telemetry.addData("Right Back Power", rbPower);

        lf.setPower(lfPower);
        lb.setPower(lbPower);

        rf.setPower(rfPower);
        rb.setPower(rbPower);
    }

}
