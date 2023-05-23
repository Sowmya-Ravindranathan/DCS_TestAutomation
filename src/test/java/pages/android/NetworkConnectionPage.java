package pages.android;

import utils.core.TestUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class NetworkConnectionPage extends TestUtils {

    public void disableWifiForWifiConnectedDevices(String[] devices) {
        for (String device : devices) {
            if (isWifiEnabled(device)) {
                String command = String.format("-s %s shell svc wifi disable", device);
                runShellProcessCommand(command);
                log("Wifi for Device " + device + "is disabled");
            }
        }
    }

    public List<String> getDevicesListIfWifiIsNotConnected(String[] devices) {
        List<String> deviceList = new ArrayList<>();
        for (String device : devices) {
            if (!isWifiEnabled(device)) {
                deviceList.add(device);
            }
        }
        return deviceList;
    }

    public HashMap<String, String> getConnectedWifiNamesOfAllDevices(String[] devices) {
        HashMap<String, String> deviceWifi = new HashMap();

        for (String device : devices) {
            if (isWifiEnabled(device)) {
                String command = String.format("-s %s shell dumpsys wifi | grep \"^SSID: \"", device);
                String data = runShellProcessCommand(command);
                String wifiName = data.replace("SSID: \"", "").replace("\"", "");
                deviceWifi.put(device, wifiName);
            }
        }
        return deviceWifi;
    }

    private boolean isWifiEnabled(String deviceId) {
        String command = String.format("-s %s shell dumpsys wifi | grep \"Wi-Fi is\"", deviceId);
        String data = runShellProcessCommand(command);
        if (data.contains("enabled")) {
            return true;
        }
        return false;
    }

    public String[] getListOfConnectedDevices() {
        String data = runShellProcessCommand("devices");
        String[] devices = data.replace("List of devices attached", "").split("device");
        Arrays.parallelSetAll(devices, (i) -> devices[i].trim());
        return devices;
    }

}
