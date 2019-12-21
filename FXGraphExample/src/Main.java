import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

import javafx.application.Application;
import javafx.stage.Stage;

/* How to import libraries to Maven
 *  https://github.com/graphstream/gs-ui-javafx/tree/2.0-alpha
 *  All examples:
 *  https://github.com/graphstream/gs-ui-javafx/tree/master/src-test/org/graphstream/ui/viewer_fx/test
 */
public class Main extends Application {

	static Stage primaryStage = new Stage();
	static Graph graph;
	
	public static void main(String[] args) {
		System.out.println("Main started");
		
		graph = new SingleGraph("Graph");
		
		Client client = new Client();
		Thread thread = new Thread(client);
		thread.start();
		client.setGraph(graph);
		
		Application.launch(GraphStyling.class, args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		GraphStyling graphstyling = new GraphStyling();
		graphstyling.setPrimaryStage(primaryStage);
	}
}
