import { ChangeDetectorRef, OnInit } from '@angular/core';
import { ManagePageService } from 'cmssmarteditcontainer/services/pages/ManagePageService';
import { CrossFrameEventService, ICatalogService, IDropdownMenuItemData, CmsitemsRestService, ICMSPage } from 'smarteditcommons';
export declare class UpdatePageStatusComponent implements OnInit {
    private cdr;
    private managePageService;
    private cmsitemsRestService;
    private catalogService;
    private crossFrameEventService;
    private dropdownMenuData;
    pageInfo: ICMSPage;
    showButton: boolean;
    constructor(cdr: ChangeDetectorRef, managePageService: ManagePageService, cmsitemsRestService: CmsitemsRestService, catalogService: ICatalogService, crossFrameEventService: CrossFrameEventService, dropdownMenuData: IDropdownMenuItemData);
    ngOnInit(): Promise<void>;
    onClickOnSync(): Promise<void>;
    private setButtonVisibility;
    private doesPageExistInActiveCatalogVersion;
}
