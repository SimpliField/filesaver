import { WebPlugin } from '@capacitor/core';

import type { FileSaverPlugin } from './definitions';

export class FileSaverWeb extends WebPlugin implements FileSaverPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
