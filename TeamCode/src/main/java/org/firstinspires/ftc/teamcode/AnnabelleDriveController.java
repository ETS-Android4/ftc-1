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

    /* Set control vals */
    public void setPower(double pwr) {
        forwardPower = pwr;
    }

    public void setRotation(double rot) {
        rotation = rot;
    }

    public void step(Telemetry telemetry) {

        double rightPower = rotation + forwardPower;
        double leftPower = -rotation + forwardPower;

        telemetry.addData("RightPower", rightPower);
        telemetry.addData("LeftPower", leftPower);

        lf.setPower(leftPower);
        lb.setPower(leftPower);

        rf.setPower(rightPower);
        rb.setPower(rightPower);
    }

}
