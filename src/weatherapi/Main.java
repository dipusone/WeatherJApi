import java.util.Timer;
import java.util.TimerTask;

public class Main {
	public static void main(String[] args) throws Exception {
		TimerTask viewWeatherTask = new ViewWeatherTask();
		Timer timer = new Timer();
		timer.schedule(viewWeatherTask, 0, 5000);
	}
}