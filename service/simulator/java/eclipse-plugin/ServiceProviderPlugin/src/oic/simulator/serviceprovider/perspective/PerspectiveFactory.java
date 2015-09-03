package oic.simulator.serviceprovider.perspective;

import oic.simulator.serviceprovider.view.AttributeView;
import oic.simulator.serviceprovider.view.LogView;
import oic.simulator.serviceprovider.view.MetaPropertiesView;
import oic.simulator.serviceprovider.view.MultiResourceOrchestrationView;
import oic.simulator.serviceprovider.view.ResourceManagerView;
import oic.simulator.serviceprovider.view.ResourceObserverView;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class PerspectiveFactory implements IPerspectiveFactory {

    public static final String PERSPECTIVE_ID = "oic.simulator.serviceprovider.perspective";
    private IPageLayout        factory;

    @Override
    public void createInitialLayout(IPageLayout factory) {
        this.factory = factory;
        factory.setEditorAreaVisible(false);
        addViews();
        factory.setFixed(false);
    }

    private void addViews() {
        factory.addView(ResourceManagerView.VIEW_ID, IPageLayout.LEFT, 0.3f,
                factory.getEditorArea());

        IFolderLayout folder = factory.createFolder(
                "oic.simulator.serviceprovider.perspective.folder",
                IPageLayout.BOTTOM, 0.65f, ResourceManagerView.VIEW_ID);
        folder.addView(MetaPropertiesView.VIEW_ID);
        folder.addView(ResourceObserverView.VIEW_ID);

        factory.addView(AttributeView.VIEW_ID, IPageLayout.LEFT, 0.7f,
                factory.getEditorArea());
        factory.addView(LogView.VIEW_ID, IPageLayout.BOTTOM, 0.65f,
                AttributeView.VIEW_ID);
        factory.addView(MultiResourceOrchestrationView.VIEW_ID,
                IPageLayout.RIGHT, 0.6f, AttributeView.VIEW_ID);
    }
}