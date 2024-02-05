import { EventEmitter } from '@angular/core';
import { IPageTreeNodeService, LogService } from 'smarteditcommons';
import { SlotNode, ComponentNode, NodeInfoService } from '../../../services/pageTree/NodeInfoService';
export declare class PageTreeSlot {
    private readonly pageTreeNodeService;
    private readonly nodeInfoService;
    private readonly logService;
    node: SlotNode;
    onSlotExpanded: EventEmitter<SlotNode>;
    private publishSlotInterval;
    constructor(pageTreeNodeService: IPageTreeNodeService, nodeInfoService: NodeInfoService, logService: LogService);
    onClickSlotNode($event: Event): Promise<void>;
    onComponentExpanded(component: ComponentNode): void;
    private checkSlotAndPublishSelected;
}
