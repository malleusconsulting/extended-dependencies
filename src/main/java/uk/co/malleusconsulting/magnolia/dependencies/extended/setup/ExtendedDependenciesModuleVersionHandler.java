package uk.co.malleusconsulting.magnolia.dependencies.extended.setup;

import info.magnolia.jcr.util.NodeTypes;
import info.magnolia.module.DefaultModuleVersionHandler;
import info.magnolia.module.InstallContext;
import info.magnolia.module.delta.ArrayDelegateTask;
import info.magnolia.module.delta.CreateNodePathTask;
import info.magnolia.module.delta.CreateNodeTask;
import info.magnolia.module.delta.IsModuleInstalledOrRegistered;
import info.magnolia.module.delta.OrderNodeAfterTask;
import info.magnolia.module.delta.SetPropertyTask;
import info.magnolia.module.delta.Task;
import info.magnolia.repository.RepositoryConstants;

import java.util.ArrayList;
import java.util.List;

public class ExtendedDependenciesModuleVersionHandler extends DefaultModuleVersionHandler {

    @Override
    protected List<Task> getExtraInstallTasks(InstallContext installContext) {
        List<Task> extraInstallTasks = new ArrayList<>();

        extraInstallTasks.add(
        new IsModuleInstalledOrRegistered("Configure Pages app", "If pages app is present, add access to dependencies viewer", "pages",
                
            new ArrayDelegateTask("Configure Pages app",

                new CreateNodeTask("View dependencies action",
                        "/modules/pages/apps/pages/subApps/browser/actions", "viewDependencies", NodeTypes.ContentNode.NAME),

                new SetPropertyTask(RepositoryConstants.CONFIG,
                        "/modules/pages/apps/pages/subApps/browser/actions/viewDependencies",
                        "extends", "/modules/extended-dependencies/generic/actions/viewDependencies"),

                new CreateNodePathTask("View dependencies action bar group",
                        "/modules/pages/apps/pages/subApps/browser/actionbar/sections/pageActions/groups/dependencyActions/items/viewDependencies",
                        NodeTypes.ContentNode.NAME),

                new OrderNodeAfterTask("Place dependency actions after edit actions",
                        "/modules/pages/apps/pages/subApps/browser/actionbar/sections/pageActions/groups/dependencyActions",
                        "editingActions"))));

        extraInstallTasks.add(
        new IsModuleInstalledOrRegistered("Configure DAM app", "If dam app is present, add access to dependencies viewer", "dam-app",

            new ArrayDelegateTask("Configure DAM app",

                new CreateNodeTask("View dependencies action",
                        "/modules/dam-app/apps/assets/subApps/browser/actions", "viewDependencies", NodeTypes.ContentNode.NAME),

                new SetPropertyTask(RepositoryConstants.CONFIG,
                        "/modules/dam-app/apps/assets/subApps/browser/actions/viewDependencies",
                        "extends", "/modules/extended-dependencies/generic/actions/viewReferences"),

                new CreateNodePathTask("View dependencies action bar group",
                        "/modules/dam-app/apps/assets/subApps/browser/actionbar/sections/asset/groups/dependencyActions/items/viewDependencies",
                        NodeTypes.ContentNode.NAME),

                new OrderNodeAfterTask("Place dependency actions after edit actions",
                        "/modules/dam-app/apps/assets/subApps/browser/actionbar/sections/asset/groups/dependencyActions",
                        "editActions"))));

        return extraInstallTasks;
    }
}