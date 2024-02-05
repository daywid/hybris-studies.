/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { NgModule } from '@angular/core';
import {
    moduleUtils,
    HttpBackendService,
    I18N_RESOURCE_URI,
    SeEntryModule
} from 'smarteditcommons';

const i18nMock = {
    en: {
        'se.media.format.desktop': 'Desktop'
    },
    en_US: {
        'abanalytics.popover.title': 'ab analytics',
        'experience.selector.catalog': 'CATALOG',
        'experience.selector.date.and.time': 'DATE/TIME',
        'experience.selector.language': 'LANGUAGE',
        'experience.selector.newfield': 'NEW FIELD',
        'experience.selector.catalogversions': 'PRODUCT CATALOGS',
        'page.displaycondition.primary': 'Primary',
        'page.displaycondition.primary.description':
            'This is a primary page and it will be displayed if no other variant page exists.',
        'page.displaycondition.variation': 'Variation',
        'page.displaycondition.variation.description':
            'This is a variant page that supports restriction rules to control the page visibility.',
        'page.restrictions.list.empty': 'This page has no restrictions',
        'se.action.back': 'Back',
        'se.action.done': 'Done',
        'se.action.next': 'Next',
        'se.actions.loadpreview': 'load preview',
        'se.perspective.advanced.name': 'Advanced CMS',
        'se.perspective.basic.name': 'Basic CMS',
        'se.perspective.none.name': 'PREVIEW',
        'se.cms.actionitem.page.clone': 'Clone',
        'se.cms.actionitem.page.edit': 'Edit',
        'se.cms.actionitem.page.sync': 'Sync',
        'se.cms.actionitem.page.trash': 'Move to Trash',
        'se.cms.addpagewizard.addpage': 'add new page',
        'se.cms.addpagewizard.pageconditions.tabname': 'Display Condition',
        'se.cms.addpagewizard.pageinfo.tabname': 'Info',
        'se.cms.addpagewizard.pagetemplate.tabname': 'Template',
        'se.cms.addpagewizard.pagetype.description':
            'SmartEdit supports page creation for the following page types',
        'se.cms.addpagewizard.pagetype.tabname': 'Type',
        'se.cms.addpagewizard.pagetype.title': 'Create Page',
        'se.cms.back.to.pagelist': 'pages',
        'se.cms.cataloginfo.btn.sync': 'SYNC',
        'se.cms.cataloginfo.lastsynced': 'LAST SYNCED',
        'se.cms.cataloginfo.lastsyncedfrom': 'last synced from {{sourceCatalogVersion}}',
        'se.cms.cataloginfo.navigationmanagement': 'NAVIGATION MANAGEMENT',
        'se.cms.cataloginfo.pagelist': 'PAGE LIST',
        'se.cms.clonepage.menu.btn.label': 'Clone',
        'se.cms.clonepagewizard.options.copies': 'Clone components',
        'se.cms.clonepagewizard.options.existing': 'Use existing components',
        'se.cms.clonepagewizard.options.title': 'Clone components in content slots',
        'se.cms.clonepagewizard.options.tooltip':
            'The content of shared slots is not impacted when cloning a page',
        'se.cms.clonepagewizard.pageclone.title': 'Clone Page',
        'se.cms.clonepagewizard.pagecloneoptions.tabname': 'Clone Options',
        'se.cms.clonepagewizard.pageinfo.tabname': 'Information',
        'se.cms.clonepagewizard.pageinfo.targetcatalogversion.label.exists.message':
            'A page with this label already exists. If you proceed, it will overwrite the existing page',
        'se.cms.clonepagewizard.pageinfo.targetcatalogversion.pagetype.exists.message':
            'The system can only have one Primary {{typeCode}}. The existing page will be overwritten.',
        'se.cms.compomentmenu.tabs.componenttypes': 'Component Types',
        'se.cms.compomentmenu.tabs.customizedcomp': 'Customized Components',
        'se.cms.component.confirmation.modal.cancel': 'Cancel',
        'se.cms.component.confirmation.modal.close': 'Close',
        'se.cms.component.confirmation.modal.save': 'Save',
        'se.cms.componentmenu.btn.label.addcomponent': 'Add Component',
        'se.cms.componentmenu.label.draganddrop': 'Drag and drop components onto page',
        'se.cms.componentmenu.search.placeholder': 'Search Component',
        'se.cms.contextmenu.removecomponent.confirmation.message':
            'Do you want to remove the component from the page?',
        'se.cms.contextmenu.removecomponent.confirmation.title': 'Remove Component',
        'se.cms.contextmenu.title.remove': 'remove',
        'se.cms.display.conditions.header.creation.date': 'Creation Date',
        'se.cms.display.conditions.header.page.name': 'Page Name',
        'se.cms.display.conditions.header.restrictions': 'Restrictions',
        'se.cms.display.conditions.label': 'Display Condition',
        'se.cms.display.conditions.no.variations': 'There are no page variations for this primary.',
        'se.cms.display.conditions.primary.description':
            'This is a primary page and it will be displayed if no other variation page exists',
        'se.cms.display.conditions.primary.id': 'Primary',
        'se.cms.display.conditions.primary.page.label': 'Primary page associated to the variation',
        'se.cms.display.conditions.variation.description':
            'This is a variation page that supports restriction rules to control the page visibility',
        'se.cms.display.conditions.variation.id': 'Variation',
        'se.cms.display.conditions.variation.pages.title':
            'Page Variations Associated to this Primary',
        'se.cms.display.conditions.variations.description':
            'The variation page with the most applicable restrictions is displayed. If more than one variation page applies, the oldest variation page is displayed',
        'se.cms.draganddrop.error': 'failed to move component component2 to slot footerSlot',
        'se.cms.editor.title.suffix': 'Editor',
        'se.genericeditor.tab.default.title': 'CONTENT',
        'se.genericeditor.tab.administration.title': 'ADMIN',
        'se.genericeditor.tab.visibility.title': 'VISIBILITY',
        'se.icon.tooltip.visibility': '{{numberOfRestrictions}} restrictions',
        'se.cms.linkto.option.category': 'Category',
        'se.cms.linkto.option.content': 'Content',
        'se.cms.linkto.option.external': 'External Link',
        'se.cms.linkto.option.product': 'Product',
        'se.cms.navigationcomponent.management.node.breadcrumb': 'Node Path',
        'se.cms.navigationcomponent.management.node.level.non.root': 'Level {{level}}',
        'se.cms.navigationcomponent.management.node.level.root': 'Root',
        'se.cms.navigationcomponent.management.node.selection.invite.action':
            'Select a node to associate to this component',
        'se.cms.navigationcomponent.management.node.selection.remove.action': 'Remove',
        'se.cms.navigationcomponent.management.node.selection.select.action': 'Select',
        'se.cms.navigationmanagement.add.top.level.node': 'Create Top Level',
        'se.cms.navigationmanagement.navnode.addchild': 'Add a Child',
        'se.cms.navigationmanagement.navnode.addsibling': 'Add a Sibling',
        'se.cms.navigationmanagement.navnode.edit': 'Edit',
        'se.cms.navigationmanagement.navnode.move.down': 'Move Down',
        'se.cms.navigationmanagement.navnode.move.up': 'Move Up',
        'se.cms.navigationmanagement.navnode.node.create.entry': 'Create Entry',
        'se.cms.navigationmanagement.navnode.node.entries': 'Entries',
        'se.cms.navigationmanagement.navnode.node.entry.add.new.message': 'Add Entry',
        'se.cms.navigationmanagement.navnode.node.entry.button.add': 'Add',
        'se.cms.navigationmanagement.navnode.node.entry.button.cancel': 'Cancel',
        'se.cms.navigationmanagement.navnode.node.entry.button.update': 'Update',
        'se.cms.navigationmanagement.navnode.node.name': 'Name',
        'se.cms.navigationmanagement.navnode.node.title': 'Title',
        'se.cms.navigationmanagement.navnode.objecttype.node': 'Node',
        'se.cms.navigationmanagement.navnode.removeentry.confirmation.message':
            'Do you want to delete the entry ?',
        'se.cms.navigationmanagement.navnode.removeentry.confirmation.title': 'Delete Entry',
        'se.cms.navigationmanagement.navnode.removenode': 'Delete',
        'se.cms.navigationmanagement.navnode.removenode.confirmation.message':
            'Deleting a node will delete all its child nodes and entries',
        'se.cms.navigationmanagement.navnode.removenode.confirmation.title': 'Delete Node',
        'se.cms.navigationmanagement.node.addentry.no.itemid.message': 'Please select an Item',
        'se.cms.navigationmanagement.node.edit.cancel': 'Cancel',
        'se.cms.navigationmanagement.node.edit.save': 'Save',
        'se.cms.navigationmanagement.node.edit.title': 'Manage Node',
        'se.cms.navigationmanagement.title': 'NAVIGATION MANAGEMENT',
        'se.cms.nestedcomponenteditor.create': 'CREATE NEW COMPONENT',
        'se.cms.nestedcomponenteditor.select.type': 'Select component type',
        'se.cms.page.condition.primary.association.label':
            'Primary page associated to the variation',
        'se.cms.page.condition.selection.label': 'Condition',
        'se.cms.page.label.label': 'Label',
        'se.cms.pageeditormodal.editpagetab.basic': 'INFORMATION',
        'se.cms.pageeditormodal.editpagetab.basic.template': 'Search results grid',
        'se.cms.pageeditormodal.editpagetab.title': 'Manage Page',
        'se.cms.pageeditormodal.page.readonly.message':
            'This page is part of a workflow and cannot be edited.',
        'se.cms.pageinfo.display.conditions.title': 'Display Condition',
        'se.cms.pageinfo.information.title': 'Page Information',
        'se.cms.pageinfo.menu.btn.label': 'Page Info',
        'se.cms.pageinfoform.datecreated': 'Date Created',
        'se.cms.pageinfoform.datemodified': 'Date Modified',
        'se.cms.pageinfoform.fromemail': 'From E-mail',
        'se.cms.pageinfoform.fromname': 'From Name',
        'se.cms.pageinfoform.id': 'Page ID',
        'se.cms.pageinfoform.label': 'Page Label',
        'se.cms.pageinfoform.name': 'Page Name',
        'se.cms.pageinfoform.title': 'Page Title',
        'se.cms.pagelist.headerpageid': 'ID',
        'se.cms.pagelist.headerpagename': 'Name',
        'se.cms.pagelist.headerpagetemplate': 'Template',
        'se.cms.pagelist.headerpagetitle': 'Page title',
        'se.cms.pagelist.headerpagetype': 'Type',
        'se.cms.pagelist.headerparentpage': 'Parent page',
        'se.cms.pagelist.headerrestrictions': 'Restrictions',
        'se.cms.page.restore.category.duplicate.primaryforvariation.error':
            'Another primary {{pageType}} page already exists. Restoring this page will move the other page to trash.',
        'se.cms.pagelist.searchplaceholder': 'Search page',
        'se.cms.pagelist.title': 'Pages',
        'se.cms.pagelist.trashcan.link.text': 'TRASH ({{totalCount}} PAGES)',
        'se.cms.perspective.advanced.name': 'Advanced CMS',
        'se.cms.perspective.basic.name': 'Basic CMS',
        'se.cms.perspective.none.name': 'PREVIEW',
        'se.cms.perspective.versioning.name': 'VERSIONING',
        'se.cms.actionitem.page.restore': 'Restore',
        'se.cms.restrictions.criteria': 'Criteria:',
        'se.cms.restrictions.criteria.all': 'Match All',
        'se.cms.restrictions.criteria.any': 'Match Any',
        'se.cms.restrictions.criteria.select.all': 'Apply all restrictions',
        'se.cms.restrictions.criteria.select.any': 'Apply any restriction',
        'se.cms.restrictions.editor.button.add.new': 'ADD NEW',
        'se.cms.restrictions.editor.tab': 'Restrictions',
        'se.cms.restrictions.item.edit': 'Edit',
        'se.cms.restrictions.item.remove': 'Remove',
        'se.cms.restrictions.list.title': 'List of restrictions',
        'se.cms.restrictions.picker.search.label': 'Restriction Name',
        'se.cms.restrictions.picker.search.placeholder': 'Search',
        'se.cms.restrictions.picker.type.label': 'Restriction Type',
        'se.cms.restrictions.picker.type.placeholder': 'Select restriction type',
        'se.cms.restrictions.toolbar.menu': 'Restrictions',
        'se.cms.sharedslot.decorator.label': 'Shared Slot: Edit in Advanced Mode',
        'se.cms.slot.shared.parent.popover.message':
            'Shared slot inherited from {{catalogVersion}}',
        'se.cms.slot.shared.popover.message': 'Slot shared from {{catalogVersion}}',
        'se.cms.slot.shared.replace.editor.title': 'Replace Slot',
        'se.cms.slot.sync.from.page.level': 'This slot can be synced from the page level',
        'se.cms.synchronization.page.header':
            'Synchronize page information, associations and content slots, except shared content slots',
        'se.cms.synchronization.page.header.help':
            'Shared slots should be synchronized from the slot on the Advanced Edit mode.',
        'se.cms.synchronization.page.new.description':
            'Sync it so that it is available in the {{catalogName}} - {{catalogVersion}}',
        'se.cms.synchronization.page.new.header': 'This is a new page.',
        'se.cms.synchronization.page.header.old.homepage':
            'To enable sync for all slots and page information, sync new homepage.',
        'se.cms.synchronization.page.select.all.slots': 'All Slots and Page Information',
        'se.cms.synchronization.page.title': 'SYNCHRONIZE PAGE',
        'se.cms.synchronization.pagelist.modal.title.prefix': 'Synchronize',
        'se.cms.synchronization.panel.failure.message': 'Sync failed for items: {{items}}',
        'se.cms.synchronization.panel.lastsync.text': 'Last Page Sync on ',
        'se.cms.synchronization.panel.live.override.warning':
            'Synchronization will overwrite Stage content to the Live Catalog.',
        'se.cms.synchronization.panel.live.recent.notice':
            'Live Catalog version has the most recent changes.',
        'se.cms.synchronization.panel.update.title': 'Updates',
        'se.cms.synchronization.slot.header': 'Sync Slot',
        'se.cms.synchronization.slots.select.all.components': 'Select All',
        'se.cms.toolbaritem.moreactions.name': 'More Actions',
        'se.cms.toolbaritem.pagesyncmenu.description':
            'This is a synchronization panel to get sync status of a page and some dependencies and to perform sync',
        'se.cms.toolbaritem.pagesyncmenu.name': 'Sync',
        'se.cms.trashedpagelist.title': 'Trash',
        'se.cms.trashedpagelist.trashed.date': 'Time Removed',
        'se.cms.slotvisibility.list.title': 'Hidden Component List',
        'se.componentform.actions.cancel': 'Cancel',
        'se.componentform.actions.exit': 'Exit',
        'se.componentform.actions.replaceImage': 'Replace Image',
        'se.componentform.actions.submit': 'Submit',
        'se.configurationform.actions.cancel': 'cancel',
        'se.configurationform.actions.close': 'close',
        'se.configurationform.actions.submit': 'submit',
        'se.confirmation.modal.cancel': 'Cancel',
        'se.confirmation.modal.missing.description': 'Confirmation modal description is required',
        'se.confirmation.modal.ok': 'OK',
        'se.confirmation.modal.title': 'Confirm',
        'se.drag.and.drop.not.valid.component.type':
            'Component {{componentUID}} not allowed in {{slotUID}}.',
        'se.editor.cancel.confirm': 'You have unsaved changes. Are you sure you want to cancel?',
        'se.editor.linkto.external.label': 'External Link',
        'se.editor.linkto.internal.label': 'Existing Page',
        'se.editor.linkto.label': 'Link to',
        'se.genericeditor.dropdown.placeholder': 'Select an image',
        'se.genericeditor.sedropdown.placeholder': 'Search...',
        'se.landingpage.homepage': 'homepage',
        'se.landingpage.title': 'Your Touchpoints',
        'se.media.format.desktop': 'Desktop',
        'se.media.format.mobile': 'Mobile',
        'se.media.format.replace': 'Replace',
        'se.media.format.replaceimage': 'Replace Image',
        'se.media.format.tablet': 'Tablet',
        'se.media.format.widescreen': 'Widescreen',
        'se.modal.administration.configuration.edit.title': 'edit configuration',
        'se.pagelist.countsearchresult': 'Pages found',
        'se.restrictions.instance': 'Instance',
        'se.restrictions.menu.btn.label': 'Restrictions',
        'se.restrictions.type': 'Type',
        'se.sync.status.synced.inprogress': 'SYNC IN PROGRESS',
        'se.sync.status.synced.syncfailed': 'SYNC FAILED',
        'se.unknown.request.error': 'Your request could not be processed! Please try again later!',
        'se.ydropdownmenu.move.down': 'Move Down',
        'se.ydropdownmenu.move.up': 'Move Up',
        'se.ydropdownmenu.remove': 'Delete',
        'se.ytree.template.header.name': 'Name',
        'se.ytree.template.header.type': 'Type',
        'some.key.for.Component': 'Component',
        'some.key.for.component1': 'Component 1',
        'some.key.for.component4': 'Component 4',
        'some.key.for.Customization': 'Customization',
        'some.key.for.MetaData': 'MetaData',
        'some.key.for.Navigation': 'Navigation',
        'some.key.for.Restrictions': 'Restrictions',
        'some.key.for.Slot': 'Slot',
        someperspective: 'Some other perspective',
        'sync.confirm.msg': 'this {{catalogName}}is a test',
        'synchronization.AbstractPage.header': 'Page information and Restrictions',
        'synchronization.bottomHeaderSlotContentSlot.header': 'Bottom Header Slot',
        'synchronization.btn.sync': 'Sync',
        'synchronization.footerSlotContentSlot.header': 'Footer Slot',
        'synchronization.otherSlotContentSlot.header': 'Other Slot',
        'synchronization.topHeaderSlotContentSlot.header': 'Top Header Slot',
        'tab1.name': 'Tab 1',
        'tab2.name': 'Tab 2',
        'tab3.name': 'Tab 3',
        'tab4.name': 'Tab 4',
        'tab5.name': 'Tab 5',
        'tab6.name': 'Tab 6',
        'tab7.name': 'Tab 7',
        'type.AbstractCMSComponent.visible.name': 'Component Visibility',
        'type.abstractcmscomponent.visible.name': 'Visible',
        'type.AbstractItem.creationtime.name': 'Created',
        'type.AbstractItem.modifiedtime.name': 'Modified',
        'type.AbstractItem.pk.name': 'Key',
        'type.cmsitem.name.name': 'Name',
        'type.cmsitem.uid.name': 'UID',
        'type.cmslinkcomponent.name': 'CMSLink Component',
        'type.cmsparagraphcomponent.headline.name': 'Headline',
        'type.cmsparagraphcomponent.id.name': 'ID',
        'type.cmsparagraphcomponent.name': 'Paragraph Component',
        'type.componenttype1.content.name': 'Content',
        'type.componenttype1.content.tooltip': 'enter content',
        'type.componenttype1.mediaContainer.name': 'Media Container',
        'type.componenttype1.name.name': 'Name',
        'type.footernavigationcomponent.name': 'Footer Component',
        'type.item.creationtime.name': 'Created',
        'type.item.modifiedtime.name': 'Modified',
        'type.Item.name.name': 'Name',
        'type.item.pk.name': 'PK',
        'type.Item.uid.name': 'ID',
        'type.productcarouselcomponent.name': 'Product Carousel Component',
        'type.simplebannercomponent.name': 'Simple Banner Component',
        'type.testsingleonlinecategoryselector.name': 'TestSingleOnlineCategorySelector',
        'type.testsingleonlineproductselector.name': 'TestSingleOnlineProductSelector',
        'type.thesmarteditcomponenttype.activationDate.name': 'Activation date',
        'type.thesmarteditcomponenttype.active.name': 'Activation',
        'type.thesmarteditcomponenttype.content.name': 'Content',
        'type.thesmarteditcomponenttype.created.name': 'Creation date',
        'type.thesmarteditcomponenttype.enabled.name': 'Enabled',
        'type.thesmarteditcomponenttype.external.name': 'External Link',
        'type.thesmarteditcomponenttype.headline.name': 'Headline',
        'type.thesmarteditcomponenttype.id.name': 'id',
        'type.thesmarteditcomponenttype.media.name': 'Media',
        'type.thesmarteditcomponenttype.orientation.name': 'Orientation',
        'type.thesmarteditcomponenttype.urlLink.name': 'Url Link',
        'type.xyzcomponent.name': 'XYZ Component',
        'se.cms.actionitem.page.trash.alert.failure.prefix':
            "'{{pageName}}' page cannot be moved to trash: ",
        'se.cms.catalogawareitem.itemtype.notsupported':
            'Cannot edit this attribute. This item type is not supported.',
        'se.cms.clonepagewizard.options.targetcatalogversion.label.exists.message':
            'The page with the same label already exists in the selected catalog version',
        'se.cms.clonepagewizard.options.targetcatalogversion.pagetype.exists.message':
            'The page already exists in the selected catalog version',
        'se.cms.component.name.clone.of.prefix': 'Clone of',
        'se.cms.slot.unshared.revert.to.shared.description':
            'Reverting the non-shared slot to a shared slot will result in all content being lost.',
        'se.cms.slot.unshared.revert.to.shared.title': 'Revert to shared slot',
        'se.cms.slot.unshared.popover.message':
            'This is a non-shared slot. Changes will only affect this page.',
        'se.cms.unshared.slot.header': 'Non-shared slot',
        'se.cms.slot.shared.clone': 'clone',
        'se.cms.slot.shared.popover.convertoptions.title': 'Convert to non-shared slot:',
        'se.cms.slot.shared.convert.to.unshared.confirmation.title': 'Convert to non-shared slot',
        'se.cms.slot.shared.convert.to.unshared.clone.components.confirmation.message':
            'Convert a shared slot to a non-shared slot cloning components.',
        'se.cms.slot.shared.convert.to.unshared.remove.components.confirmation.message':
            'Convert a shared slot to a non-shared slot removing all components.',
        'se.cms.slot.shared.popover.text.clonecomponents':
            'Component types such as navigation components will not be cloned.',
        'se.cms.slot.shared.popover.text.removecomponents': 'Your slot will be empty.',
        'se.cms.slot.shared.popover.button.clonecomponents': 'Clone components',
        'se.cms.slot.shared.popover.button.removecomponents': 'Remove components',
        'type.cmstab.name': 'Cms Tab',
        'type.banner.name': 'Banner Component',
        'type.responsivebanner.name': 'Responsive Banner',
        'se.cms.contextmenu.title.clone.component': 'Clone',
        'se.componentform.required.field': 'This field is required.',
        'se.moretext.more.link': 'more',
        'se.moretext.less.link': 'less',
        'se.cms.actionitem.versions': 'Versions',
        'se.cms.versions.search.placeholder': 'Search version',
        'se.cms.versions.search.versions.found': '{{versionsFound}} Versions',
        'se.cms.toolbaritem.versioning.manageversions.name': 'Manage',
        'se.cms.toolbaritem.versioning.noversionsfound': 'No versions of this page exist.',
        'se.cms.versions.unselect.version':
            'The version is no longer selected. You are viewing the current state of the page.',
        'se.cms.versions.no.description': 'No description',
        'se.cms.versions.create': 'Create New Version',
        'se.cms.versions.editor.button.cancel': 'Cancel',
        'se.cms.versions.editor.button.save': 'Save',
        'se.cms.versions.editor.description.name': 'Description',
        'se.cms.versions.editor.label.name': 'Version Label',
        'se.cms.actionitem.page.versions.create': 'Create Version',
        'se.cms.actionitem.page.versions.rollback': 'Rollback',
        'se.cms.actionitem.page.version.rollback.confirmation.title':
            'Rollback To Previous Version',
        'se.cms.actionitem.page.version.rollback.confirmation.description':
            'Rollback the page to version, {{versionLabel}}.  As part of the rollback, the current state of the page will be saved as a separate version.',
        'se.cms.actionitem.page.versions': 'Versions',
        'se.cms.version.item.menu.delete.label': 'Delete',
        'se.cms.version.item.menu.edit.label': 'Edit Details',
        'se.cms.version.item.menu.view.label': 'View',
        'se.cms.version.item.menu.rollback.label': 'Rollback to this Version',
        'se.cms.actionitem.page.version.delete.confirmation.title': 'Delete Version',
        'se.cms.actionitem.page.version.delete.confirmation.description':
            'Confirm you want to permanently delete this version.',
        'se.cms.page.permanently.delete.alert.success': 'Page permanently deleted.',
        'se.cms.actionitem.page.permanently.delete.confirmation.description':
            "Permanently delete page '{{pageName}}'",
        'se.cms.actionitem.page.permanently.delete.confirmation.title': 'Permanently Delete',
        'se.cms.actionitem.page.permanently.delete': 'Permanently Delete',
        'se.deviceorientation.vertical.label': 'Vertical',
        'se.deviceorientation.horizontal.label': 'Horizontal',
        'se.cms.workflow.editor.start.workflow.title': 'Start Workflow',
        'se.cms.workflow.editor.edit.workflow.title': 'Workflow',
        'se.cms.workflow.editor.description': 'Description',
        'se.cms.workflow.editor.template': 'Workflow',
        'se.cms.workflow.editor.create.version': 'Create page version',
        'se.cms.workflow.editor.button.save': 'Save',
        'se.cms.workflow.editor.button.start': 'Start',
        'se.cms.workflow.create.alert.success': 'Workflow started successfully',
        'se.cms.workflow.cancel.confirmation.title': 'Cancel Workflow',
        'se.cms.workflow.cancel.confirmation.description':
            'When canceling workflow, the page will be moved back to Draft',
        'se.cms.workflow.cancel.alert.success': 'Workflow canceled successfully',
        'se.cms.workflow.toolbar.start.workflow': 'Start Workflow',
        'se.cms.actionitem.page.workflow.cancel': 'Cancel Workflow',
        'se.cms.actionitem.page.workflow.description': 'Workflow Description',
        'se.cms.workflow.toolbar.view.workflow.menu': 'Page Tasks',
        'se.cms.page.approval.approved': 'Ready To Sync',
        'se.cms.page.approval.check': 'Draft',
        'se.cms.page.displaystatus.draft': 'Draft',
        'se.cms.page.displaystatus.in_progress': 'In Progress',
        'se.cms.page.displaystatus.ready_to_sync': 'Ready To Sync',
        'se.cms.page.displaystatus.synced': 'Synched',
        'se.cms.page.displaystatus.lastpublished.date': 'Last Published',
        'se.cms.page.displaystatus.not.published': 'Not Published Yet',
        'se.draganddrop.uihint.top': 'Place mouse here to scroll up',
        'se.draganddrop.uihint.bottom': 'Place mouse here to scroll down',
        'se.cms.catalogaware.catalogitemtype.product': 'Products',
        'se.cms.catalogaware.catalogitemtype.category': 'Categories',
        'se.cms.alert.component.removed.from.slot':
            'The component {{componentID}} has been removed from slot {{slotID}}',
        'se.cms.page.workflow.tabs.currenttasks': 'Current',
        'se.cms.page.workflow.tabs.alltasks': 'All',
        'se.cms.page.workflow.action.item.comment.header': 'Comment',
        'se.cms.actionitem.page.workflow.action.no.comments.available': 'No History Available.',
        'se.cms.actionitem.page.workflow.action.started.hours.ago': ' HOUR(S) AGO',
        'se.cms.actionitem.page.workflow.action.started.days.ago': ' DAY(S) AGO',
        'se.cms.actionitem.page.workflow.action.status.started': ' STARTED',
        'se.cms.actionitem.page.workflow.action.status.not.started': ' NOT STARTED',
        'se.cms.actionitem.page.workflow.no.description': 'No description',
        'se.cms.workflow.editor.comment': 'Comment',
        'se.cms.workflow.editor.button.submit': 'Submit',
        'se.cms.workflow.toolbar.inbox': 'Inbox',
        'se.application.name': 'SmartEdit',
        'se.toolbar.sites': 'Sites',
        'se.wait.dialog.message': 'loading',
        'se.cms.toolbaritem.navigationmenu.name': 'Navigation',
        'se.cms.synchronization.slot.disabled.msg': 'To sync, update page status to Ready to Sync.',
        'se.cms.actionitem.page.permanently.delete.blocked':
            'The page must be synched before permanently deleting it.',
        'se.cms.sync.page.status.confirm.title': 'Sync Page Status',
        'se.cms.sync.page.status.confirm.description':
            'Do you want to sync the page status to the {{catalogVersion}} catalog version? This will update the page status to "DELETED" in {{catalogVersion}} catalog version.',
        'se.cms.sync.page.status.success.alert':
            '{{pageId}} page has be successfully trashed in {{catalogVersion}} catalog version.',
        'se.cms.pagelist.headerpagestatus': 'Status',
        'se.cms.tooltip.current.homepage.movetotrash':
            'This is the homepage. It cannot be moved to trash.',
        'se.uploaded.image.code': 'Code',
        'se.uploaded.image.alt.text': 'Alt Text'
    }
};

@SeEntryModule('i18nMocks')
@NgModule({
    providers: [
        moduleUtils.provideValues({
            SMARTEDIT_ROOT: 'smartedit-build/webroot',
            SMARTEDIT_RESOURCE_URI_REGEXP: /^(.*)\/apps\/cms-smartedit-e2e\/generated\/(e2e|pages)/,
            SMARTEDIT_INNER_FILES: [
                '/apps/cms-smartedit-e2e/node_modules/ckeditor4/ckeditor.js',
                '/apps/cms-smartedit-e2e/generated/e2e/base/cms-smartedit/vendor.js',
                '/apps/cms-smartedit-e2e/generated/e2e/base/cms-smartedit/base-inner-app.js'
            ],
            SMARTEDIT_INNER_FILES_POST: [
                '/apps/cms-smartedit-e2e/generated/e2e/base/cms-smartedit/inner-app.js'
            ]
        }),
        moduleUtils.initialize(
            (httpBackendService: HttpBackendService) => {
                httpBackendService
                    .whenGET(new RegExp(I18N_RESOURCE_URI + '/[\\w]+'))
                    .respond(function (method: string, url: string) {
                        const locale = url.substr(url.lastIndexOf('/') + 1);
                        return [200, (i18nMock as any)[locale]];
                    });
            },
            [HttpBackendService]
        )
    ]
})
/* tslint:disable:class-name */
export class i18nMocks {}

window.pushModules(i18nMocks);
