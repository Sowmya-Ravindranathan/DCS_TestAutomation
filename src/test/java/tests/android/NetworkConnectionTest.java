package tests.android;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.android.NetworkConnectionPage;
import java.util.HashMap;
import java.util.List;

public class NetworkConnectionTest {
    String[] devices = null;
    NetworkConnectionPage page;

    @BeforeMethod
    public void beforeMethod() {
        page = new NetworkConnectionPage();
        devices = page.getListOfConnectedDevices();
    }

    @Test
    public void getConnectedWifiNetworkNames() {
        HashMap<String, String> deviceWifi = page.getConnectedWifiNamesOfAllDevices(devices);
        System.out.println("Devices connected on Wifi " + deviceWifi);
    }

    @Test
    public void getWifiNotConnectedDevicesUDID() {
        List<String> noWifiDevices = page.getDevicesListIfWifiIsNotConnected(devices);
        System.out.println(noWifiDevices);
    }

    @Test
    public void disableWifiConnectionToDevices() {
        page.disableWifiForWifiConnectedDevices(devices);
    }
}
