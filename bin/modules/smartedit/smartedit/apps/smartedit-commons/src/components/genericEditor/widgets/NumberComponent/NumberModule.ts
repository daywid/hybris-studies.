/*
 * Copyright (c) 2022 SAP SE or an SAP affiliate company. All rights reserved.
 */
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { TranslateModule } from '@ngx-translate/core';

import { NumberComponent } from './NumberComponent';

@NgModule({
    imports: [CommonModule, TranslateModule.forChild(), FormsModule],
    declarations: [NumberComponent],
    entryComponents: [NumberComponent],
    exports: [NumberComponent]
})
export class NumberModule {}
