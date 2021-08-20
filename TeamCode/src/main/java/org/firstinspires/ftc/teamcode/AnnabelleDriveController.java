package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class AnnabelleDriveController extends FourWheelDriveController {

    public AnnabelleDriveController(DcMotor lfm, DcMotor lbm, DcMotor rfm, DcMotor rbm) {
        super(lfm, lbm, rfm, rbm);

        lf.setDirection(DcMotor.Direction.FORWARD);
        lb.setDirection(DcMotor.Direction.FORWARD);
        rf.setDirection(DcMotor.Direction.REVERSE);
        rb.setDirection(DcMotor.Direction.REVERSE);
    }

    public void step(Telemetry telemetry) {
        setSidePower(SIDE_RIGHT, rotation + forwardPower);
        setSidePower(SIDE_LEFT, -rotation + forwardPower);

        telemetry.addData("Left Power", lfPower);
        telemetry.addData("Right Power", rfPower);

        super.step();
    }
}
