import { EventEmitter, OnChanges, SimpleChanges } from '@angular/core';
import { ISelectItem } from '@smart/utils';
import { Observable } from 'rxjs';
import { Tab } from './types';
export declare class TabsComponent<T> implements OnChanges {
    model: T;
    tabsList: Tab[];
    numTabsDisplayed: number;
    onTabSelected: EventEmitter<string>;
    selectedTab: Tab;
    selectItems: ISelectItem<Tab>[];
    dropdownTabs: ISelectItem<Tab>[];
    private tabChangedStream;
    get isInitialized(): boolean;
    isActiveInMoreTab(): boolean;
    ngOnChanges(changes: SimpleChanges): void;
    selectTab(tabToSelect: Tab): void;
    dropDownHasErrors(): boolean;
    findSelectedTab(): void;
    getDropdownTabs(): Observable<ISelectItem<Tab>[]>;
    getVisibleTabs(): Observable<Tab[]>;
    trackTabById(index: number): number;
}
