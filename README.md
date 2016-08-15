# extended-dependencies
##Description
Extension of the Magnolia Dependencies Module to allow quick access via a workbench

##Installation
For an example, build the module and install alongside content with inter-dependencies configured in the standard Dependencies Module. This can be the standard Magnolia Travel demo content.

Alternatively this module is available from [the central Maven repository](http://repo1.maven.org/maven2/uk/co/malleusconsulting/magnolia/dependencies/extended/extended-dependencies-module/1.1.1/) and can be installed using:

```xml
<dependency>
  <groupId>uk.co.malleusconsulting.magnolia.dependencies.extended</groupId>
  <artifactId>extended-dependencies-module</artifactId>
  <version>1.1.1</version>
</dependency>
```

##Usage
The module will install two new actions, viewReferences and viewDependencies, that use a dialog launched from a browser subapp to show dependencies to and from a node. The actions do not require write permissions on the node which is particularly useful in the assets app as opening the edit dialog here requires this permission, despite dependency viewing being a read-only activity.

The module will also reconfigure the pages/apps/pages and dam-app/apps/assets apps to add these actions to the action bar when a page or asset node is selected.

<img src="https://raw.githubusercontent.com/malleusconsulting/extended-dependencies/gh_pages/new_action_view_dependencies.png" width="601" height="365" title="New Action" />

<img src="https://raw.githubusercontent.com/malleusconsulting/extended-dependencies/gh_pages/viewing_dependencies.png" width="601" height="365" title="Viewing page dependencies" />

The standard Dependencies Module allows the viewing of nodes the selected item is dependent on as well as those that are dependent on the current selection. Some node types, such as assets, do not normally have dependencies so it is clearer to simply view those that reference the current selection. This is achieved using the viewReferences action rather than viewDependencies which launches a less detailed dialog.

<img src="https://raw.githubusercontent.com/malleusconsulting/extended-dependencies/gh_pages/view_references.png" width="601" height="365" title="Viewing asset references" />

 