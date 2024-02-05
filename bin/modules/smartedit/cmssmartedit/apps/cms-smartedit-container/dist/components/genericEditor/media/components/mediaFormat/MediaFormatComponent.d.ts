import { EventEmitter, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { GenericEditorFieldMessage, GenericEditorMediaType, MediaSelectorI18nKey } from 'smarteditcommons';
import { Media, MediaService, MediaUtilService } from '../../services';
export declare class MediaFormatComponent implements OnInit, OnChanges {
    private mediaService;
    private mediaUtilService;
    errorMessages: GenericEditorFieldMessage[];
    isEditable: boolean;
    isUnderEdit: boolean;
    isFieldDisabled: boolean;
    mediaUuid: string | undefined;
    mediaFormat: string;
    mediaLabel: string;
    allowMediaType: GenericEditorMediaType;
    onFileSelect: EventEmitter<FileList>;
    onDelete: EventEmitter<void>;
    media: Media | null;
    mediaFormatI18nKey: string;
    mediaSelectorI18nKeys: MediaSelectorI18nKey;
    acceptedFileTypes: string[];
    constructor(mediaService: MediaService, mediaUtilService: MediaUtilService, mediaSelectorI18nKey: MediaSelectorI18nKey);
    ngOnInit(): Promise<void>;
    ngOnChanges(changes: SimpleChanges): Promise<void>;
    onFileSelectorFileSelect(file: FileList): void;
    onRemoveButtonClick(): void;
    isMediaPreviewEnabled(): boolean;
    isMediaAbsent(): boolean;
    getErrors(): string[];
    private fetchAndSetMedia;
}