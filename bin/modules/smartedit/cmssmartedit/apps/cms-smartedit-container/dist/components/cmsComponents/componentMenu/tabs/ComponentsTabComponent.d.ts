import { OnInit, Type } from '@angular/core';
import { ComponentService } from 'cmscommons';
import { ISharedDataService, FetchStrategy, Page, TabData, CMSItem, ComponentMenuService, CatalogVersion } from 'smarteditcommons';
import { CatalogVersionItemComponent } from '../components';
import { ComponentMenuTabModel } from '../types';
export declare class ComponentsTabComponent implements OnInit {
    private tabData;
    private componentMenuService;
    private componentService;
    private sharedDataService;
    catalogVersions: CatalogVersion[];
    catalogVersionsFetchStrategy: FetchStrategy<CatalogVersion>;
    cloneOnDrop: boolean;
    componentsContext: {
        items: CMSItem[];
    };
    forceRecompile: boolean;
    itemComponent: Type<CatalogVersionItemComponent>;
    searchTerm: string;
    selectedCatalogVersionId: string;
    selectedCatalogVersion: CatalogVersion;
    constructor(tabData: TabData<ComponentMenuTabModel>, componentMenuService: ComponentMenuService, componentService: ComponentService, sharedDataService: ISharedDataService);
    ngOnInit(): Promise<void>;
    isActive(): boolean;
    hasMultipleContentCatalogs(): boolean;
    trackById(item: CatalogVersion): string;
    onCatalogVersionChange(): Promise<void>;
    onSearchTermChanged(searchTerm: string): void;
    loadComponentItems: (mask: string, pageSize: number, currentPage: number) => Promise<Page<CMSItem>>;
    onComponentCloneOnDropChange(): void;
    private fetchCatalogVersions;
}
