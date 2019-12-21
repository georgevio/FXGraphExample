import org.graphstream.graph.Graph;
import org.graphstream.ui.fx_viewer.FxViewPanel;
import org.graphstream.ui.fx_viewer.FxViewer;
import org.graphstream.ui.javafx.FxGraphRenderer;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Client implements Runnable {
	
	GraphStyling graphstyling;
	static Graph graph;
	
		
	public Client() { /* constructor */
		System.out.println("Client constructed");
	}
	public void setGraph(Graph graph) {
		this.graph = graph;
		System.out.println("Graph passed to Client");
	}
	
    @Override
    public void run(){
    	graphstyling = new GraphStyling();
    	graphstyling.setGraph(graph);
    	System.out.println("Client.run()");
    	graph.addNode("1"); graph.addNode("2");//graph.addEdge("1","2","1-->2");
    	
    }
}
