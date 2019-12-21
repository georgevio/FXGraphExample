import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.MultiGraph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.stream.thread.ThreadProxyPipe;
import org.graphstream.ui.fx_viewer.FxDefaultView;
import org.graphstream.ui.fx_viewer.FxViewPanel;
import org.graphstream.ui.fx_viewer.FxViewer;
import org.graphstream.ui.javafx.FxGraphRenderer;
import org.graphstream.ui.view.Viewer;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GraphStyling extends Application {

	private static Graph graph;
	private Scene scene;
	private Stage primaryStage;
	
	public void start(Stage primaryStage) { /* constructor */
		/* for advanced graph effects */
		System.setProperty("org.graphstream.ui.renderer", "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
		System.setProperty("org.graphstream.ui", "javafx");
	
		graph.addNode("3"); graph.addNode("5");
		System.out.println("GraphStyling started");
		
		MultiGraph graph2 = new MultiGraph("g2");
		graph2.addNode("j1"); graph2.addNode("jj3");graph2.addNode("jj4");
		
		/* Two graphs in one window */
		/*
		ThreadProxyPipe pipe1 = new ThreadProxyPipe() ;
		pipe1.init(graph);
		ThreadProxyPipe pipe2 = new ThreadProxyPipe() ;
		pipe2.init(graph2);
		Viewer viewer1 = new FxViewer(pipe1);
		Viewer viewer2 = new FxViewer(pipe2);
		FxDefaultView view1 = new FxDefaultView(viewer1, "view1", new FxGraphRenderer());
		FxDefaultView view2 = new FxDefaultView(viewer2, "view2", new FxGraphRenderer());
		viewer1.addView(view1);
		viewer2.addView(view2);
		viewer1.enableAutoLayout();
		viewer2.enableAutoLayout();
		GridPane gridpane = new GridPane();
		gridpane.add(view1, 1, 0);
		gridpane.add(view2, 2, 0);
		Scene scene = new Scene(gridpane, 800, 600, true, SceneAntialiasing.BALANCED);
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
        
        primaryStage.show();
		*/
		/* Standard graph view as a standalone window */
		//Viewer viewer = graph.display(true);
		//viewer.enableAutoLayout();
		
    	FxViewer v = new FxViewer(graph, FxViewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
    	v.enableAutoLayout();
    	FxViewPanel panel = (FxViewPanel)v.addDefaultView(false, new FxGraphRenderer());
    	scene = new Scene(panel, 800, 600);
    	
    	primaryStage.setScene(scene);	
		primaryStage.show();
	}
	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public void setGraph(Graph graph) { /* getter */
		this.graph = graph;
		System.out.println("GraphStyling graph set");
	}
}
