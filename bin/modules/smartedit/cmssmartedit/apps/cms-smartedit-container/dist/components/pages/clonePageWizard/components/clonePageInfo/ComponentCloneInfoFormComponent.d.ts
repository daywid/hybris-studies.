import { EventEmitter, OnDestroy, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { PageFacade } from 'cmssmarteditcontainer/facades';
import { GenericEditorAPI, GenericEditorStructure, ICatalogVersion, IUriContext, LanguageService, SystemEventService, IPageService, ICMSPage } from 'smarteditcommons';
export declare class ComponentCloneInfoFormComponent implements OnInit, OnDestroy {
    private translateService;
    private languageService;
    private pageFacade;
    private pageService;
    private systemEventService;
    content: ICMSPage;
    pageTemplate: string;
    pageTypeCode: string;
    structure: GenericEditorStructure;
    targetCatalogVersion: ICatalogVersion;
    uriContext: IUriContext;
    submit: () => void;
    reset: () => void;
    isDirty: () => void;
    isValid: () => void;
    isDirtyChange: EventEmitter<() => void>;
    isValidChange: EventEmitter<() => void>;
    submitChange: EventEmitter<() => void>;
    resetChange: EventEmitter<() => void>;
    catalogVersionContainsPageWithSameTypeCode: boolean;
    genericEditorId: string;
    isDirtyInternal: () => void;
    isValidInternal: () => void;
    submitInternal: () => void;
    resetInternal: () => void;
    private pageLabel;
    private pageInfoEditorApi;
    private genericEditorLoadEventUnsubscribe;
    constructor(translateService: TranslateService, languageService: LanguageService, pageFacade: PageFacade, pageService: IPageService, systemEventService: SystemEventService);
    ngOnInit(): Promise<void>;
    ngOnDestroy(): void;
    setGenericEditorApi(api: GenericEditorAPI): void;
    private isUriContextEqualToCatalogVersion;
    private handleWarningMessage;
    private toggleWarningMessage;
}
