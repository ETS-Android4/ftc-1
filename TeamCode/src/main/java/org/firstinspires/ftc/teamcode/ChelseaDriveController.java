package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class ChelseaDriveController extends FourWheelDriveController {

    double strafe;

    public ChelseaDriveController(DcMotor lfm, DcMotor lbm, DcMotor rfm, DcMotor rbm) {
        super(lfm, lbm, rfm, rbm);

        lf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rf.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        lb.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        lf.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lb.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rf.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lb.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void setStrafe(double str) {
        strafe = str;
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

        super.step();
    }
}
