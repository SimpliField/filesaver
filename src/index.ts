import { registerPlugin } from '@capacitor/core';

import type { FileSaverPlugin } from './definitions';

const FileSaver = registerPlugin<FileSaverPlugin>('FileSaver');

export * from './definitions';
export { FileSaver };
