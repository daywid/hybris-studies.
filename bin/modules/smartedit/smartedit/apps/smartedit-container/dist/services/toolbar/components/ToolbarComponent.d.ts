import './toolbar.scss';
import { ChangeDetectorRef, Injector, OnDestroy, OnInit } from '@angular/core';
import { IIframeClickDetectionService, IToolbarServiceFactory, SmarteditRoutingService, SystemEventService, ToolbarItemInternal } from 'smarteditcommons';
import { ToolbarService } from '../services/ToolbarService';
export declare class ToolbarComponent implements OnInit, OnDestroy {
    private toolbarServiceFactory;
    private iframeClickDetectionService;
    private systemEventService;
    private injector;
    private cdr;
    private routingService;
    static readonly CLOSE_ALL_ACTION_ITEMS = "closeAllActionItems";
    cssClass: string;
    toolbarName: string;
    imageRoot: string;
    aliases: ToolbarItemInternal[];
    private unregCloseActions;
    private unregCloseAll;
    private unregRecalcPermissions;
    private toolbarService;
    constructor(toolbarServiceFactory: IToolbarServiceFactory<ToolbarService>, iframeClickDetectionService: IIframeClickDetectionService, systemEventService: SystemEventService, injector: Injector, cdr: ChangeDetectorRef, routingService: SmarteditRoutingService);
    ngOnInit(): void;
    ngOnDestroy(): void;
    triggerAction(action: ToolbarItemInternal, $event: Event): void;
    getItemVisibility(item: ToolbarItemInternal): boolean;
    isOnStorefront(): boolean;
    createInjector(item: ToolbarItemInternal): Injector;
    trackByFn(_: number, item: ToolbarItemInternal): string;
    private closeAllActionItems;
    private populatePermissions;
    private setup;
    private buildAliases;
    private registerCallbacks;
}