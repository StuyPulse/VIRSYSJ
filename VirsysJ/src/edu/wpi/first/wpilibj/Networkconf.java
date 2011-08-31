/* config files for the ipaddress and ports for virsys*/
package edu.wpi.first.wpilibj;
public interface Networkconf{
    //IP address of computer running VIRSYS physics simulation
    //Use 127.0.0.1 for the local machine
    //final String VIRSYS_IP = "192.168.1.149";
    final String Virsys_IP = "192.168.1.142";

    //VIRSYS host port
    //In the host's VIRSYS director, match virsysPhysics.txt "local receive port"
    final int VIRSYS_RECV_PORT = 50001;

    //Match host's virsysPhysics.txt "LabView host port"
    final int LOCAL_RECV_PORT = 50002;
}