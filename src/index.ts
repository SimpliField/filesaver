import { registerPlugin } from '@capacitor/core';

import type { FileSaverPlugin } from './definitions';

const FileSaver = registerPlugin<FileSaverPlugin>('FileSaver', {
  web: () => import('./web').then(m => new m.FileSaverWeb()),
});

export * from './definitions';
export { FileSaver };
