import { CdkDragMove } from "@angular/cdk/drag-drop";
import { OnInit, DoCheck, OnDestroy } from "@angular/core";
import { TranslateService } from "@ngx-translate/core";
import { PersonalizationsmarteditMessageHandler, PersonlizationSearchExtensionInjector } from "personalizationcommons";
import { SearchRestService, SearchProfilesContextService } from "personalizationsearchsmarteditcontainer/service";
import { SearchProfileAction, SearchProfileItem } from "personalizationsearchsmarteditcontainer/types";
export declare class SearchProfilesSmarteditComponent implements OnInit, DoCheck, OnDestroy {
    private personlizationSearchExtensionInjector;
    private document;
    private translateService;
    private searchRestService;
    private searchProfilesContextService;
    private personalizationsmarteditMessageHandler;
    selectedSearchProfile: SearchProfileItem;
    allSearchProfiles: SearchProfileItem[];
    availableSearchProfiles: SearchProfileItem[];
    searchProfileActions: SearchProfileAction[];
    moreSearchProfilestRequestProcessing: boolean;
    searchProfileContext: any;
    getSelectedTypeCode: () => string;
    fetchStrategy: {
        fetchAll: () => Promise<SearchProfileItem[]>;
    };
    private seData;
    private actions;
    private getCustomization;
    private getVariation;
    private addAction;
    private isActionInSelectDisabled;
    private searchProfileFilter;
    private paginationHelper;
    private customizationPreCode;
    private variationPreCode;
    private actionsPreCount;
    private draggedItemCss;
    private dropTargetIds;
    private nodeLookup;
    private dropAction;
    private dragMovedSubscription;
    private dragMovedSubject;
    constructor(personlizationSearchExtensionInjector: PersonlizationSearchExtensionInjector, document: Document, translateService: TranslateService, searchRestService: SearchRestService, searchProfilesContextService: SearchProfilesContextService, personalizationsmarteditMessageHandler: PersonalizationsmarteditMessageHandler);
    ngOnInit(): void;
    ngDoCheck(): void;
    ngOnDestroy(): void;
    getPage: () => Promise<any>;
    getSearchProfileCode(): string;
    searchProfileSelectedEvent: (selectedSearchProfile: SearchProfileItem) => void;
    dragMoved(event: CdkDragMove<any>): void;
    dragDropped(event: any): void;
    private getWrapperActionForAction;
    private checkDragDrop;
    private checkDragDropIndex;
    private updateSearchProfileActionsBaseIndex;
    private setStatusForUpdatedActions;
    private updateSearchProfileActionsDragDrop;
    private resetSearchProfileActionsDragDrop;
    private performDragMoved;
    private showDragInfo;
    private clearDragInfo;
    private addMoreSearchProfilesItems;
    private getIndexTypes;
    private isItemInSelectDisabled;
    private getSearchProfileFilterObject;
    private buildAction;
    private formateSearchProfileItem;
}
