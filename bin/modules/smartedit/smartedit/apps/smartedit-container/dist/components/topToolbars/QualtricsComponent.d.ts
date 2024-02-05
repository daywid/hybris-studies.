import { OnDestroy, OnInit } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { SettingsService } from 'smarteditcommons';
import './cx-qtx-survey-button.bundle.js';
export declare class QualtricsComponent implements OnInit, OnDestroy {
    private translateService;
    private settingService;
    interceptUrl: string;
    contextParamsString: string;
    private contextParams;
    constructor(translateService: TranslateService, settingService: SettingsService);
    ngOnDestroy(): void;
    ngOnInit(): void;
    private _getFixedContextParams;
}
